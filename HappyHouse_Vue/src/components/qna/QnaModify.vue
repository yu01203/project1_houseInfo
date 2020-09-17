<template>
  <div class="container" align="center">
    <div class="col-lg-6" align="center">
      <h1>질문게시판</h1>
      <div class="form-group" align="center">
        <h5>제목 :</h5>
        <textarea class="form-control" id="title" name="title" v-model="qnaitem.qna_title"></textarea>
      </div>
      <div class="form-group2" align="center">
        <h5>내용 :</h5>
        <textarea
          class="form-control"
          rows="15"
          id="content"
          name="content"
          v-model="qnaitem.qna_content"
        ></textarea>
        <!-- <div>{{this.$session.get('noticeDetailKey')}}</div> -->
      </div>
    </div>
    <button type="button" class="btn btn-primary" @click="checkHandlerModify">수정완료</button>
    <router-link to="/qna" class="btn btn-primary">취소</router-link>
  </div>
</template>

<script>
import http from "@/util/http-common";
import moment from "moment";
import { mapGetters } from "vuex";
export default {
  name: "detail",
  computed: {
    ...mapGetters(["qnaitem"])
  },
  methods: {
    getFormatDate(qna_datetime) {
      return moment(new Date(qna_datetime)).format("YYYY.MM.DD HH:mm:ss");
    },
    deleteHandler() {
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
    },
    checkHandlerModify() {
      let err = true;
      let msg = "";
      !this.qnaitem.qna_title &&
        ((msg = "제목을 입력해주세요"),
        (err = false),
        this.$refs.qnaitem.qna_title.focus());
      err &&
        !this.qnaitem.qna_content &&
        ((msg = "내용 입력해주세요"),
        (err = false),
        this.$refs.qnaitem.qna_content.focus());

      if (!err) alert(msg);
      else this.modifyHandler();
    },
    modifyHandler() {
      http
        .put(`/qna/${this.qnaitem.qna_no}`, {
          qna_no: this.qnaitem.qna_no,
          qna_userid: this.qnaitem.qna_userid,
          qna_title: this.qnaitem.qna_title,
          qna_content: this.qnaitem.qna_content
        })
        .then(({ data }) => {
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "수정이 완료되었습니다.";
          }
          this.$router.push("/qna");
          alert(msg);
          this.$router.go();
        })
        .catch(() => {
          alert("수정 처리시 에러가 발생했습니다.");
        });
    }
  }
};
</script>
<style>
h5{
  text-align: left;
}
</style>