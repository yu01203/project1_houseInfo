<template>
<tbody>
    <tr>
      <td>{{ qna_no }}</td>
      <td>
        <router-link :to="`/qnaRead?qna_no=${qna_no}`">{{ qna_title }}</router-link>
      </td>
      <td>{{ qna_userid }}</td>
      <td>{{ getFormatDate(qna_datetime) }}</td>
    </tr>
    </tbody>
</template>

<script>
import moment from "moment";
export default {
  name: "row",
  props: {
    qna_no: Number,
    qna_userid: String,
    qna_title: String,
    qna_datetime: String,
    qna_content: String,
  },
  methods: {
    getFormatDate(qna_datetime) {
      return moment(new Date(qna_datetime)).format("YYYY.MM.DD");
    }
  }
};
</script>
