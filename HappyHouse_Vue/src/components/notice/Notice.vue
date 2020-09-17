<template>
  <div class="overflow-auto">
    <h1>공 지 사 항</h1>
    <div v-if="this.$session.get('id') == 'admin'">
      <router-link to="/noticeWrite" class="nav-link" align="right">글쓰기</router-link>
    </div>
    
    <b-table 
      id="my-table"
      :items="noticeitems"
      :fields="fields"
      striped
      hover
      :per-page="perPage"
      :current-page="currentPage"
      small
      @row-clicked="rowClicked"
      
    >


    </b-table>

    <b-pagination
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      aria-controls="my-table"
      align="center"
    ></b-pagination>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  data() {
    return {
      perPage: 10,
      currentPage: 1,
      fields: [
        {key: 'content', thClass: 'd-none', tdClass: 'd-none' },
        {key: 'notice_no', sortable: true},
        {key: 'notice_id', sortable: true},
        {key: 'notice_title', sortable: true},
        {key: 'notice_regtime', sortable: true},
        
    ],
    };
  },
  methods: {
    //rowClicked(item, index) {
    rowClicked(item) {
      //alert("Index: " + index + "\n\nItem: " + JSON.stringify(item) + item.articleno + " " + index); //너무 힘들게 찾음 ㅡㅡ

      this.$session.set("notice_no", item.notice_no);
      this.$session.set("notice_id", item.notice_id);
      this.$session.set("notice_title", item.notice_title);
      this.$session.set("notice_content", item.notice_content);
      this.$router.push("/noticeDetail");
    }
  },
  computed: {
    rows() {
      return this.noticeitems.length;
    },
    ...mapGetters(["noticeitems"])
  },
  created() {
    this.$store.dispatch("getNotices");
  }
  
};
</script>

<style>
h1 {
  text-align: center;
  margin-bottom: 150px;
}
.page-link {
  margin-top: 60px;
}
</style>