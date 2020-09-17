<template>
  <tr id="third">
    <div v-if="qna_no == this.$session.get('qna_no')">
        
        <td id="first" class="form-control">아이디: {{ reply_userid }}  |  작성시간: {{reply_datetime}}</td>
        <td id="second" class="form-control">{{ reply_content }}</td>
      <br />
      <!-- <td>{{ qna_no }}</td>
      <td>{{ this.$session.get('qna_no') }}</td> -->
    </div>
    <!-- <h5>이번값:{{qna_no}} 세션값:{{ this.$session.get('qna_no') }}</h5> -->
  </tr>
</template>

<script>
export default {
  name: "row",
  props: {
    reply_no: Number,
    reply_userid: String,
    qna_no: Number,
    reply_datetime: String,
    reply_content: String
  },
  methods: {}
};
</script>
<style>
#second {
    height: 100%;
    background: #E6E6E6;
    width: 100%;
}
</style>