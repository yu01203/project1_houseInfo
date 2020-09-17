<template>
  <div>
    <h1>질문게시판 글쓰기</h1>
    <div class="container" align="center">
      <div class="col-lg-6" align="center">
        <form id="writeform" method="post" action>
          <input type="hidden" name="act" id="act" value="write" />f
          <div class="form-group" align="left">
            <label for="content">내용:</label>
            <textarea
              class="form-control"
              rows="15"
              id="qna_content"
              ref="qna_content"
              placeholder="내용을 입력하세요"
              v-model="reply_content"
            ></textarea>
          </div>
          <button type="button" class="btn btn-primary" @click="checkHandler">답변작성</button>
          <button type="reset" class="btn btn-warning">초기화</button>
          <router-link to="/qna" class="btn btn-primary">취소</router-link>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
export default {
  name: "reply-Form",
  props: {
    type: { type: String }
  },
  data: function() {
    return {
      reply_no: "",
      reply_userid: "",
      qna_no: "",
      reply_content: "",
      reply_datetime: ""
    };
  },
  methods: {
    checkHandler() {
      let err = true;
      let msg = "";
      !this.reply_content &&
        ((msg = "내용을 입력해주세요"),
        (err = false),
        this.$refs.reply_content.focus());

      if (!err) alert(msg);
      else this.createHandler();
    },
    createHandler() {
      http
        .post("/reply", {
          qna_no: this.$route.query.qna_no,
          reply_userid : this.$session.get('id'),
          reply_content: this.reply_content,
        })
        .then(({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
          this.$router.push('/qna');
        })
        .catch(() => {
          alert("등록 처리시 에러가 발생했습니다.");
        });
    }
    
  }
  
};
</script>

<style>
button {
  margin-right: 20px;
  margin-left: 20px;
}
</style>

