<template>
  <tr>
    <td class="bbc">
      <a class="ababc" v-on:click="gotoNoticeDetail" style="cursor:pointer;">● {{notice_title}}</a>
    </td>
      <br>
      <br>
  </tr>

</template>

<script>
export default {
  name: "row",
  props: {
    notice_no: Number,
    notice_title: String,
    notice_id : String,
    notice_content : String,
  },
  methods: {
    gotoNoticeDetail() {
      this.$session.set("notice_no", this.notice_no);
      this.$session.set("notice_id", this.notice_id);
      this.$session.set("notice_title", this.notice_title);
      this.$session.set("notice_content", this.notice_content);
      this.$router.push('/noticeDetail');
    }
  }
};
</script>

<style>
.ababc{
  display: inline-block; 
  width:auto; left:0; right:0; position:absolute;
  white-space: nowrap; 
  overflow: hidden; 
  text-overflow: ellipsis;
  margin-left: 30px;
  margin-right: 30px;
  font-family: Georgia;
  
  /* 글자체, 글자크기, 글자간격 
  공지사항의 경우 오른쪽 빈 간격이 너무 넓어 보기 싫ㅇ므
  여백을 줄이는 방향으로 ㄱㄱ*/
}

</style>
