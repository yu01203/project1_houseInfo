<template>
  <div class="container" align="center">
    <div class="col-lg-6" align="center">
      <h1>관련정책 게시판</h1>
      <div class="form-group" align="center">
        <h5>제목 :</h5>
        <textarea
          class="form-control"
          disabled="disabled"
          id="title"
          name="title"
          v-model="policyitem.policy_title"
        ></textarea>
      </div>
      <div class="form-group2"  align="center">
        <h5>내용 :</h5>
        <textarea
          class="form-control"
          disabled="disabled"
          rows="18"
          id="content"
          name="content"
          v-model="policyitem.policy_content"
        ></textarea>
      </div>
    </div>
    <div v-if="this.$session.get('id') == 'admin'"> 
    <router-link :to="`/policyModify?policy_no=${policyitem.policy_no}`" class="btn btn-primary">수정</router-link>
    <button type="button" class="btn btn-warning" @click="deleteHandler">삭제</button>
    <router-link to="/policy" class="btn btn-primary">취소</router-link>
    </div>
    <div v-if="this.$session.get('id') != 'admin'"> 
    <router-link to="/policy" class="btn btn-primary">취소</router-link>
    </div>
    

  </div>
</template>

<script>
import http from "@/util/http-common";
import moment from "moment";
import { mapGetters } from "vuex";
export default {
  name: "detail",
  computed: {
    ...mapGetters(["policyitem"]),
  },
  methods: {
    getFormatDate(policy_datetime) {
      return moment(new Date(policy_datetime)).format("YYYY.MM.DD HH:mm:ss");
    },
    deleteHandler() {
      http
        .delete(`/policy/${this.policyitem.policy_no}`)
        .then(({ data }) => {
          let msg = "삭제 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "삭제가 완료되었습니다.";
          }
          alert(msg);
          this.$router.push("/policy");
        })
        .catch(() => {
          alert("삭제 처리시 에러가 발생했습니다.");
        });
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
textarea {
    max-width: 1000px;
}
</style>