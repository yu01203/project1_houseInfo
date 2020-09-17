<template>
  <div>
    <h1>주택거래목록페이지</h1>
    <div>
        구군 : <select id="gugun" v-model="gugun" @change="gugunChange" ref="gugun">
            <option value="0">선택</option>
            <option v-for="(element, index) in guguns" :key="index + '_elements'" :value="element">
                {{element}}
            </option>
        </select>
        읍면동 : <select id="dong" v-model="dong" ref="dong">
            <option value="0">선택</option>
            <option v-for="(element, index) in dongs" :key="index + '_elements'" :value="element">
                {{element}}
            </option>
        </select>
        <button id="search" type="button" @click="check">검색</button>
    </div>
    <div>
		<input type="checkbox" id="aptDeal" v-model="aptdeal" ref="aptdeal">아파트 매매 
		<input type="checkbox" id="aptRent" v-model="aptrent" >아파트 전월세 
        <input type="checkbox" id="rhdeal" v-model="rhdeal">연립 다세대 매매 
        <input type="checkbox" id="rhrent" v-model="rhrent">연립 다세대 전월세
	</div>
    
    <div>
        <b-table 
            id="deals-table"
            :items="deals"
            :per-page="perPage"
            :current-page="currentPage"
            small
        ></b-table>

        <b-pagination
            v-model="currentPage"
            :total-rows="rows"
            :per-page="perPage"
            @change="pageChange"
            aria-controls="deals-table"
            align="center"
        ></b-pagination>
    </div>

    <div align="center">
        <div>
            <input type="checkbox" id="env" v-model="env" @change="envChange"> 환경
            <input type="checkbox" id="shop" v-model="shop"> 상가
            <div v-if="shop">
                대분류 : <select id="main" v-model="main" @change="mainChange">
                    <option value="0">선택</option>
                    <option v-for="(element, index) in mainc" :key="index + '_elements'" :value="element.main_code">
                        {{element.main_name}}
                    </option>
                </select>
                중분류 : <select id="middle" v-model="middle" @change="middleChange">
                    <option value="0">선택</option>
                    <option v-for="(element, index) in middlec" :key="index + '_elements'" :value="element.middle_code">
                        {{element.middle_name}}
                    </option>
                </select>
                 소분류 : <select id="sub" v-model="sub" @change="subChange">
                    <option value="0">선택</option>
                    <option v-for="(element, index) in subc" :key="index + '_elements'" :value="element.sub_code">
                        {{element.sub_name}}
                    </option>
                </select>
                <button id="show" type="button" @click="show">표시</button>
            </div>
        </div>
        <GmapMap
          :center="center"
          :zoom="zoom"
          map-type-id="terrain"
          style="width: 70%; height: 500px"
        >
            <GmapMarker
              :key="index"
              v-for="(m, index) in markers"
              :position="m.position"
              :clickable="true"
              :draggable="false"
              :icon="m.icon"
              @click="clickMarker(index)"
            />
        </GmapMap> 
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import axios from 'axios';

export default {
    name: "List",
    data() {
        return {
            gugun: "0",
            dong: "0",
            aptdeal: true,
            aptrent: true,
            rhdeal: false,
            rhrent: false,
            perPage: 10,
            currentPage: 1,
            center: {
                lat: 37.566535,
                lng: 126.9779692
            },
            zoom: 11.5,
            markers: [],
            env: false,
            shop: false,
            main: "0",
            middle: "0",
            sub: "0",
        }
    },
    computed: {
        ...mapGetters(['guguns', 'dongs', 'deals', 'mainc', 'middlec', 'subc', 'shops', 'envs']),
        rows() {
            return this.deals.length
        }
    },
    methods: {
        gugunChange() {
            this.dong="0";
            this.$store.dispatch('getDongs', this.gugun);
        },
        mainChange() {
            this.middle="0";
            this.$store.dispatch('getMiddlec', this.main);
        },
        middleChange() {
            this.sub="0";
            this.$store.dispatch('getSubc', this.middle);
        },
        subChange() {
            let markers = [];
            for(let i=0; i<this.markers.length; i++) {
                let marker = this.markers[i];
                if(marker.type != "shops") {
                    markers.push(marker);
                }
            }
            this.markers = markers;

            let bean = {
                dong: this.dong,
                sub: this.sub
            }
            this.shops = [];
            this.$store.dispatch('getShops', bean);
        },
        show() {
            for(let i=0; i<this.shops.length; i++) {
                let shop = this.shops[i];
                let marker = {position: {lat: parseFloat(shop.lat), lng: parseFloat(shop.lng)}, icon: "http://maps.google.com/mapfiles/ms/icons/green-dot.png", type: "shops"}
                this.markers.push(marker);
            }
            console.log(this.markers);
        },
        envChange() {
            if(this.env) {
                console.log("환경");
                this.$store.dispatch('getEnvs', this.dong);

                for(let i=0; i<this.envs.length; i++) {
                    let env = this.envs[i];
                    
                    axios
                        .get(`https://maps.googleapis.com/maps/api/geocode/json?address=${env.address}&key=AIzaSyCD1wK6VrNk0ef5FGUK9McpAEsG0GvAD7M`)
                        .then((response) => {
                            let marker = {position:"", icon: "http://maps.google.com/mapfiles/ms/icons/red-dot.png", type: "envs"};
                            marker.position = response.data.results[0].geometry.location;
                            this.markers.push(marker);
                        })
                        .catch((error) => {
                            console.dir(error);
                    });
                }
            }
            else {
                let markers = [];
                for(let i=0; i<this.markers.length; i++) {
                    let marker = this.markers[i];
                    if(marker.type != "envs") {
                        markers.push(marker);
                    }
                }

                this.markers = markers;
            }
        },
        check() {
            let err = true;
            let msg = "";
            (this.gugun === "0") && (msg = '구군을 선택해주세요.', err = false, this.$refs.gugun.focus());
            err && (this.dong === "0") && ((msg = '동을 선택해주세요.'), (err = false), (this.$refs.dong.focus()));
            err && (!this.aptdeal && !this.aptrent) && ((msg = '하나의 타입은 선택해주세요.'), (err = false), (this.$refs.aptdeal.focus()));

            if (!err) alert(msg);
            else {
                this.search();
            }
        },
        search() {
            let bean = {
                dongName: this.dong,
                type: [this.aptdeal, this.aptrent, this.rhdeal, this.rhrent]
            }
            this.$store.dispatch('getDeals', bean);

            axios
                .get(`https://maps.googleapis.com/maps/api/geocode/json?address=${this.dong}&key=AIzaSyCD1wK6VrNk0ef5FGUK9McpAEsG0GvAD7M`)
                .then((response) => {
                    this.center = response.data.results[0].geometry.location;
                    this.zoom=14;
                })
                .catch((error) => {
                    console.dir(error);
            });

            let markers = [];

            for(let i=0; i<this.perPage; i++) {
                let deal = this.deals[i];
                
                axios
                    .get(`https://maps.googleapis.com/maps/api/geocode/json?address=${deal.dong_name}${deal.name}&key=AIzaSyCD1wK6VrNk0ef5FGUK9McpAEsG0GvAD7M`)
                    .then((response) => {
                        let marker = {position:"", icon: "http://maps.google.com/mapfiles/ms/icons/blue-dot.png", type: "deals"};
                        marker.position = response.data.results[0].geometry.location;
                        markers.push(marker);
                    })
                    .catch((error) => {
                        console.dir(error);
                });
            }
            this.markers = markers;
        },
        clickMarker(index) {
            console.log(index);
        },
        pageChange(page) {
            let markers = [];
            for(let i=0; i<this.markers.length; i++) {
                let marker = this.markers[i];
                if(marker.type != "deals") {
                    markers.push(marker);
                }
            }
            this.markers = markers;

            for(let i=0; i<this.perPage; i++) {
                let deal = this.deals[(page-1)*10 + i];
                
                axios
                    .get(`https://maps.googleapis.com/maps/api/geocode/json?address=${deal.dong_name}${deal.name}&key=AIzaSyCD1wK6VrNk0ef5FGUK9McpAEsG0GvAD7M`)
                    .then((response) => {
                        let marker = {position:"", icon: "http://maps.google.com/mapfiles/ms/icons/blue-dot.png", type: "deals"};
                        marker.position = response.data.results[0].geometry.location;
                        this.markers.push(marker);
                    })
                    .catch((error) => {
                        console.dir(error);
                });
            }
        }
    },
    created() {
        this.$store.dispatch('getGuguns');
        this.$store.dispatch('getMainc');
    }
}
</script>

<style>

</style>