import Vue from 'vue';
import VueRouter from 'vue-router';

import Index from '@/components/page/Index.vue';
import Login from '@/components/login/LoginForm.vue';
import Notice from '@/components/notice/Notice.vue';
import NoticeWrite from '@/components/notice/NoticeWrite.vue';
import NoticeDetail from '@/components/notice/NoticeDetail.vue';
import NoticeModify from '@/components/notice/NoticeModify.vue';
import Qna from '@/components/qna/Qna.vue';
import QnaDetail from '@/components/qna/QnaDetail.vue';
import QnaRead from '@/components/qna/QnaRead.vue';
import QnaModify from '@/components/qna/QnaModify.vue';
import QnaWrite from '@/components/qna/QnaWrite.vue';
import ReplyWrite from '@/components/qna/ReplyWrite.vue';
import Policy from '@/components/policy/Policy.vue';
import PolicyDetail from '@/components/policy/PolicyDetail.vue';
import PolicyRead from '@/components/policy/PolicyRead.vue';
import PolicyModify from '@/components/policy/PolicyModify.vue';
import PolicyWrite from '@/components/policy/PolicyWrite.vue';
import DealList from "@/components/Deal/List.vue"
import Duce from "@/components/Duce.vue"

Vue.use(VueRouter);

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index,
    },
    {
      path: '/login',
      name: 'login',
      component: Login,
    },
    {
      path: '/notice',
      name: 'notice',
      component: Notice,
    },
    {
      path: '/noticeWrite',
      name: 'noticeWrite',
      component: NoticeWrite,
    },
    {
      path: '/noticeDetail',
      name: 'noticeDetail',
      component: NoticeDetail,
    },
    {
      path: '/noticeModify',
      name: 'noticeModify',
      component: NoticeModify,
    },
    {
      path: '/qna',
      name: 'qna',
      component: Qna,
    },
    {
      path: '/qnaDetail',
      name: 'qnaDetail',
      component: QnaDetail,
    },
    {
      path: '/qnaRead',
      name: 'qnaRead',
      component: QnaRead,
    },
    {
      path: '/qnaModify',
      name: 'qnaModify',
      component: QnaModify,
    },
    {
      path: '/qnaWrite',
      name: 'qnaWrite',
      component: QnaWrite,
    },
    {
      path: '/replyWrite',
      name: 'replyWrite',
      component: ReplyWrite,
    },
    {
      path: "/deal/list",
      name: "DealList",
      component: DealList,
    },
    {
      path: "/policy",
      name: "policy",
      component: Policy
    },
    {
      path: '/policyDetail',
      name: 'policyDetail',
      component: PolicyDetail,
    },
    {
      path: '/policyRead',
      name: 'policyRead',
      component: PolicyRead,
    },
    {
      path: '/policyModify',
      name: 'policyModify',
      component: PolicyModify,
    },
    {
      path: '/policyWrite',
      name: 'policyWrite',
      component: PolicyWrite,
    },
    {
      path: '/duce',
      name: 'duce',
      component: Duce,
    },
  ],
});