<template>
<tbody>
    <tr>
      <td>{{ policy_no }}</td>
      <td class="ababcd">
        <router-link :to="`/policyRead?policy_no=${policy_no}`">{{ policy_title }}</router-link>
      </td>
      <td>{{ policy_userid }}</td>
      <td>{{ getFormatDate(policy_datetime) }}</td>
    </tr>
    </tbody>
</template>

<script>
import moment from "moment";
export default {
  name: "row",
  props: {
    policy_no: Number,
    policy_userid: String,
    policy_title: String,
    policy_datetime: String,
    policy_content: String,
  },
  methods: {
    getFormatDate(policy_datetime) {
      return moment(new Date(policy_datetime)).format("YYYY.MM.DD");
    }
  }
};
</script>
<style>
.ababcd{
 text-overflow:ellipsis; overflow:hidden; white-space:nowrap;


}
</style>