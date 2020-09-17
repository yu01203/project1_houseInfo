<template>
  <div>
    <h1>정책관련 게시판 글쓰기</h1>
    <div class="container" align="center">
      <div class="col-lg-6" align="center">
        <form id="writeform" method="post" action>
          <input type="hidden" name="act" id="act" value="write" />
          <div class="form-group" align="left">
            <label for="title">제목:</label>
            <input
              type="text"
              class="form-control"
              id="policy_title"
              ref="policy_title"
              placeholder="제목을 입력하세요"
              v-model="policy_title"
            />
          </div>
          <div class="form-group" align="left">
            <label for="content">내용:</label>
            <textarea
              class="form-control"
              rows="15"
              id="policy_content"
              ref="policy_content"
              placeholder="내용을 입력하세요"
              v-model="policy_content"
            ></textarea>
          </div>
          <button type="button" class="btn btn-primary" @click="checkHandler">글작성</button>
          <button type="reset" class="btn btn-warning">초기화</button>
          <router-link to="/policy" class="btn btn-primary">취소</router-link>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
export default {
  name: "qna-Form",
  props: {
    type: { type: String }
  },
  data: function() {
    return {
      policy_no: "",
      policy_userid: "",
      policy_title: "",
      policy_content: "",
      policy_datetime: ""
    };
  },
  methods: {
    checkHandler() {
      let err = true;
      let msg = "";
      !this.policy_title &&
        ((msg = "제목을 입력해주세요"),
        (err = false),
        this.$refs.policy_title.focus());
      err &&
        !this.policy_content &&
        ((msg = "내용을 입력해주세요"), (err = false), this.$refs.policy_content.focus());

      if (!err) alert(msg);
      else this.createHandler();
    },
    createHandler() {
      http
        .post("/policy", {
          policy_title: this.policy_title,
          policy_userid : this.$session.get('id'),
          policy_content: this.policy_content,
        })
        .then(({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
          this.$router.push('/policy');
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
