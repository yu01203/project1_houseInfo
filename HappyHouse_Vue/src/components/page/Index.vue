<template>
  <div>
    <img src="@/image/Main_Image.jpg" />
    <div class="container">
      <div class="row">
        <div class="col-sm-4 col-md-4">
          <div class="post news">
            <div class="post-img-content">
              <img src="@/image/공지사항.png" class="img-responsive" />
            </div>
            <div class="content">
              <div>
                <div v-if="noticeitems.length">
                  <table class="table table-borderless table-condensed table-active" >
                    <colgroup>
                      <col :style="{ width: '3%' }" />
                      <col :style="{ width: '100%' }" />
                      
                    </colgroup>
                    <tr>
                      <th></th>
                      <th></th>
                    </tr>
                    <list-row
                      v-for="(item, index) in limitArray(noticeitems,5)"
                      :key="`${index}_items`"
                      :notice_no="item.notice_no"
                      :notice_title="item.notice_title"
                      :notice_id ="item.notice_id"
                      :notice_content ="item.notice_content"
                    />
                  </table>
                </div>
                <div v-else>글이 없습니다.</div>
              </div>
              <div></div>
            </div>
          </div>
        </div>
        <div class="col-sm-5 col-md-5">
          <div class="post work">
            <div class="post-img-content">
              <img src="@/image/관련정책.png" class="img-responsive" />
              <!-- <span class="post-date">Lorem Ipsum</span> -->
            </div>
            <div class="content">
              <div>
                  <div v-if="policyitems.length">
                    <table class="table table-borderless table-condensed table-active" >
                      <colgroup>
                        <col :style="{ width: '3%' }" />
                        <col :style="{ width: '100%' }" />
                        
                      </colgroup>
                      <tr>
                        <th></th>
                        <th></th>
                      </tr>
                      <list-row2
                        v-for="(item, index) in limitArray(policyitems,5)"
                        :key="`${index}_items`"
                        :policy_no="item.policy_no"
                        :policy_title="item.policy_title"
                        :policy_id ="item.policy_id"
                        :policy_content ="item.policy_content"
                      />
                    </table>
                  </div>
                  <div v-else>글이 없습니다.</div>
                </div>
              <div></div>
            </div>
          </div>
        </div>
        <div class="col-sm-3 col-md-3">
          <div class="post feed">
            <div class="post-img-content">
              <img src="@/image/질문게시판.png" class="img-responsive" />
            </div>
            <div class="content">
                <div>
                  <div v-if="qnaitems.length">
                    <table class="table table-borderless table-condensed table-active" >
                      <colgroup>
                        <col :style="{ width: '3%' }" />
                        <col :style="{ width: '100%' }" />
                        
                      </colgroup>
                      <tr>
                        <th></th>
                        <th></th>
                      </tr>
                      <list-row3
                        v-for="(item, index) in limitArray(qnaitems,5)"
                        :key="`${index}_items`"
                        :qna_no="item.qna_no"
                        :qna_title="item.qna_title"
                        :qna_id ="item.qna_id"
                        :qna_content ="item.qna_content"
                      />
                    </table>
                  </div>
                  <div v-else>글이 없습니다.</div>
                </div>
              <div></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import ListRow from "@/components/page/RowNotice.vue";
import ListRow2 from "@/components/page/RowPolicy.vue";
import ListRow3 from "@/components/page/RowQna.vue";
export default {
  name: "list",
  components: {
    ListRow,
    ListRow2,
    ListRow3,
  },
  computed: {
    ...mapGetters(["noticeitems"]),
    ...mapGetters(["policyitems"]),
    ...mapGetters(["qnaitems"]),
  },
  created() {
    this.$store.dispatch("getNotices");
    this.$store.dispatch("getPolicys");
    this.$store.dispatch("getQnas");
  },
  methods: {
    limitArray(arr, length = 5) {
      if (arr && arr.length) {
        if (length == -1) {
          return arr;
        }
        if (length > arr.length) {
          return arr;
        }

        return arr.slice(0, length);
      }
      return null;
    }
  }
};
</script>


<style>
.row {
  padding-top: 100px;
}



</style>
