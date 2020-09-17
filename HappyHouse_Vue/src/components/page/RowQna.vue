<template>
  <tr>
    <td>
      <a class="ababc" v-on:click="gotoQnaDetail" style="cursor:pointer;">● {{qna_title}}</a>
    </td>
          <br>
      <br>
  </tr>
</template>

<script>
export default {
  name: "row",
  props: {
    qna_no: Number,
    qna_title: String,
    qna_id : String,
    qna_content : String,
  },
  methods: {
    gotoQnaDetail() {
      this.$session.set("qna_no", this.qna_no);
      this.$session.set("qna_id", this.qna_id);
      this.$session.set("qna_title", this.qna_title);
      this.$session.set("qna_content", this.qna_content);
      this.$router.push(`/qnaRead?qna_no=${this.qna_no}`);
    }
  }
};
</script>

<style>


</style>
