<template>
  <div>
    <detail />
  </div>
</template>

<script>
import Detail from '@/components/policy/PolicyDetail.vue';
export default {
  name: 'read',
  components: {
    Detail,
  },
  created() {
    this.$session.set("policy_no", this.$route.query.policy_no);
    this.$store.dispatch('getPolicy', `/policy/${this.$route.query.policy_no}`);
  },
};
</script>

<style></style>