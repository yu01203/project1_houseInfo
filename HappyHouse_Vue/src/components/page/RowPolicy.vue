<template>
  <tr>
    <td>
      <a class="ababc" v-on:click="gotoPolicyDetail" style="cursor:pointer;">● {{policy_title}}</a>
    </td>
          <br>
      <br>
  </tr>
</template>

<script>
export default {
  name: "row",
  props: {
    policy_no: Number,
    policy_title: String,
    policy_id : String,
    policy_content : String,
  },
  methods: {
    gotoPolicyDetail() {
      this.$session.set("policy_no", this.policy_no);
      this.$session.set("policy_id", this.policy_id);
      this.$session.set("policy_title", this.policy_title);
      this.$session.set("policy_content", this.policy_content);
      this.$router.push(`/policyRead?policy_no=${this.policy_no}`);
    }
  }
};
</script>

<style>

</style>
