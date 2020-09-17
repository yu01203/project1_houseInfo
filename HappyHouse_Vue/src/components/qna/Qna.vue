<template>
  <div>
    <h2>질문게시판</h2>
    <div class="text-right">
      <div v-if="this.$session.get('id') != null"> 
      <router-link to="/qnaWrite" class="nav-link" align="right">글쓰기</router-link>
      </div>
    </div>
    <div v-if="qnaitems.length">
      <table class="table tabl-striped table-condensed">
        
        <colgroup>
          <col :style="{ width: '7%' }" />
          <col :style="{ width: '50%' }" />
          <col :style="{ width: '10%' }" />
          <col :style="{ width: '25%' }" />
        </colgroup>
        <thead>
        <tr id= "qnahead">
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>날짜</th>
        </tr>
        </thead>
        <list-row
          v-for="(qnaitem, index) in qnaitems"
          :key="`${index}_items`"
          :qna_no="qnaitem.qna_no"
          :qna_title="qnaitem.qna_title"
          :qna_userid="qnaitem.qna_userid"
          :qna_datetime="qnaitem.qna_datetime"
          :qna_content="qnaitem.qna_content"
        />
      </table>
          <b-pagination
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      aria-controls="my-table"
      align="center"
    ></b-pagination>
    </div>
    <div v-else>글이 없습니다.</div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import ListRow from "@/components/qna/QnaRow.vue";
export default {
  name: "list",
  components: {
    ListRow
  },
  computed: {
    ...mapGetters(["qnaitems"])
  },
  created() {
    this.$store.dispatch("getQnas");
  },
  methods: {
  }
};
</script>

<style>
h2 {
  text-align: center;
}
#qnahead{
  background-color: #F2F2F2;
}
</style>