<template>
  <div class="container" align="center">
    <div class="col-lg-6" align="center">
      <h1>질문게시판</h1>
      <div class="form-group" align="center">
        <h5>제목 :</h5>
        <textarea
          class="form-control"
          disabled="disabled"
          id="title"
          name="title"
          v-model="qnaitem.qna_title"
        ></textarea>
      </div>
      <div class="form-group2" align="center">
        <h5>내용 :</h5>
        <textarea
          class="form-control"
          disabled="disabled"
          rows="15"
          id="content"
          name="content"
          v-model="qnaitem.qna_content"
        ></textarea>
        <!-- <div>{{this.$session.get('noticeDetailKey')}}</div> -->
      </div>
    </div>
    <div v-if="this.$session.get('id') == qnaitem.qna_userid"> 
    <router-link :to="`/qnaModify?qna_no=${qnaitem.qna_no}`" class="btn btn-primary">수정</router-link>
    <button type="button" class="btn btn-warning" @click="deleteHandler">삭제</button>
    <router-link to="/qna" class="btn btn-primary">취소</router-link>
    </div>
    <div v-else-if="this.$session.get('id') == 'admin'"> 
    <router-link :to="`/qnaModify?qna_no=${qnaitem.qna_no}`" class="btn btn-primary">수정</router-link>
    <button type="button" class="btn btn-warning" @click="deleteHandler">삭제</button>
    <router-link to="/qna" class="btn btn-primary">취소</router-link>
    </div>
    <div v-else> 
    <router-link to="/qna" class="btn btn-primary">취소</router-link>
    </div>

    <div class="col-lg-6" align="center" id="reply_answer">
      <h1>답변</h1>
      <div v-if="this.$session.get('id') != null"> 
        <router-link :to="`/replyWrite?qna_no=${qnaitem.qna_no}`" class="nav-link" align="right">답변쓰기</router-link>
      </div>
      <div v-if="replyitems.length">
        <table class="table table-bordered table-condensed">
          <!-- <colgroup>
            <col :style="{ width: '100%' }" />
            <col :style="{ width: '50%' }" />
          </colgroup> -->
          <tr>
            <!-- <th>아이디</th> -->
            
          </tr>
          <list-row
            v-for="(replyitem, index) in replyitems"
            :key="`${index}_items`"
            :reply_no="replyitem.reply_no"
            :qna_no="replyitem.qna_no"
            :reply_userid="replyitem.reply_userid"
            :reply_datetime="replyitem.reply_datetime"
            :reply_content="replyitem.reply_content"
          />
        </table>
      </div>
      <div v-else>댓글이 없습니다.</div>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import moment from "moment";
import { mapGetters } from "vuex";
import ListRow from "@/components/qna/ReplyRow.vue";
export default {
  name: "detail",
  components: {
    ListRow
  },
  computed: {
    ...mapGetters(["qnaitem"]),
    ...mapGetters(["replyitems"]),
  },
  created() {
    // this.$store.dispatch("getQnas");
    
    this.$store.dispatch("getReplys");
  },
  methods: {
    getFormatDate(qna_datetime) {
      return moment(new Date(qna_datetime)).format("YYYY.MM.DD HH:mm:ss");
    },
    deleteHandler() {
      http
        .delete(`/reply/${this.qnaitem.qna_no}`)
        .then(({ data }) => {
          let msg = "삭제 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "삭제가 완료되었습니다.";
          }
          alert(msg);
          this.delete2Handler();
          
        })
        .catch(() => {
          alert("삭제 처리시 에러가 발생했습니다.");
        });

        
    },
    delete2Handler() {
      http
        .delete(`/qna/${this.qnaitem.qna_no}`)
        .then(({ data }) => {
          let msg = "삭제 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "삭제가 완료되었습니다.";
          }
          alert(msg);
          this.$router.push("/qna");
        })
        .catch(() => {
          alert("삭제 처리시 에러가 발생했습니다.");
        });

        this.delete2Handler();
    },
  }
};
</script>
<style>
h5 {
  text-align: left;
}
#reply_answer {
  margin-top: 40px;
}
</style>