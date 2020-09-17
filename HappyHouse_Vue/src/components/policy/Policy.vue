<template>
  <div>
    <h2>주택관련 정책 게시판</h2>
    <br>
    <br>
    <div class="text-right">
      <div v-if="this.$session.get('id') == 'admin'"> 
      <router-link to="/policyWrite" class="nav-link" align="right">글쓰기</router-link>
      </div>
    </div>
    <div v-if="policyitems.length">
      <table class="table tabl-striped table-condensed">
        
        <colgroup>
          <col :style="{ width: '7%' }" />
          <col :style="{ width: '50%' }" />
          <col :style="{ width: '10%' }" />
          <col :style="{ width: '15%' }" />
        </colgroup>
        <thead>
        <tr id ="policyhead">
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>날짜</th>
        </tr>
        </thead>
        <list-row
          v-for="(policyitem, index) in policyitems"
          :key="`${index}_items`"
          :policy_no="policyitem.policy_no"
          :policy_title="policyitem.policy_title"
          :policy_userid="policyitem.policy_userid"
          :policy_datetime="policyitem.policy_datetime"
          :policy_content="policyitem.policy_content"
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
import ListRow from "@/components/policy/PolicyRow.vue";
export default {
  name: "list",
  components: {
    ListRow
  },
  computed: {
    ...mapGetters(["policyitems"])
  },
  created() {
    this.$store.dispatch("getPolicys");
  },
  methods: {
  }
};
</script>

<style>
h2 {
  text-align: center;
}
table{
  table-layout: fixed
}
#policyhead{
  background-color: #F2F2F2;
}
</style>