<template>
  <div>
    <detail />
  </div>
</template>

<script>
import Detail from '@/components/qna/QnaDetail.vue';
export default {
  name: 'read',
  components: {
    Detail,
  },
  created() {
    this.$session.set("qna_no", this.$route.query.qna_no);
    this.$store.dispatch('getQna', `/qna/${this.$route.query.qna_no}`);
  },
};
</script>

<style></style>