import Vue from 'vue';
import Vuex from 'vuex';
import http from '@/util/http-common';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    items: [],
    item: {},
    noticeitems: [],
    noticeitem: {},
    policyitems: [],
    policyitem: {},
    qnaitems: [],
    qnaitem: {},
    replyitems: [],
    replyitem: {},
    deals: [],
    deal: {},
    guguns: [],
    dongs: [],
    mainc: [],
    middlec: [],
    subc: [],
    shops: [],
    envs:[],
  },
  getters: {
    items(state) {
      return state.items;
    },
    item(state) {
      return state.item;
    },
    noticeitems(state) {
      return state.noticeitems;
    },
    noticeitem(state) {
      return state.noticeitem;
    },
    policyitems(state) {
      return state.policyitems;
    },
    policyitem(state) {
      return state.policyitem;
    },
    qnaitems(state) {
      return state.qnaitems;
    },
    qnaitem(state) {
      return state.qnaitem;
    },
    replyitems(state) {
      return state.replyitems;
    },
    replyitem(state) {
      return state.replyitem;
    },
    guguns(state) {
      return state.guguns;
    },
    dongs(state) {
      return state.dongs;
    },
    deals(state) {
      return state.deals;
    },
    mainc(state) {
      return state.mainc;
    },
    middlec(state) {
      return state.middlec;
    },
    subc(state) {
      return state.subc;
    },
    shops(state) {
      return state.shops;
    },
    envs(state) {
      return state.envs;
    },
  },
  mutations: {
    setBoards(state, payload) {
      state.items = payload;
    },
    setBoard(state, payload) {
      state.item = payload;
    },
    setNotices(state, payload) {
      state.noticeitems = payload;
    },
    setNotice(state, payload) {
      state.noticeitem = payload;
    },
    setQnas(state, payload) {
      state.qnaitems = payload;
    },
    setQna(state, payload) {
      state.qnaitem = payload;
    },
    setPolicys(state, payload) {
      state.policyitems = payload;
    },
    setPolicy(state, payload) {
      state.policyitem = payload;
    },
    setReplys(state, payload) {
      state.replyitems = payload;
    },
    setReply(state, payload) {
      state.replyitem = payload;
    },
    setGuguns(state, payload) {
      state.guguns = payload;
    },
    setDongs(state, payload) {
      state.dongs = payload;
    },
    setDeals(state, payload) {
      state.deals = payload;
    },
    setMainc(state, payload) {
      state.mainc = payload;
    },
    setMiddlec(state, payload) {
      state.middlec = payload;
    },
    setSubc(state, payload) {
      state.subc = payload;
    },
    setShops(state, payload) {
      state.shops = payload;
    },
    setEnvs(state, payload) {
      state.envs = payload;
    },
    // getDeals(state, payload) {
    //   http.post('/deal/list', payload)
    //   .then(({data}) => {
    //     state.deals = data;
    //     // context.commit('setDeals', data);
    //   })
    //   .catch(() => {
    //     alert("에러가 발생했습니다.");
    //   });
    // },
  },
  actions: {
    getBoards(context) {
      http
        .get('/member')
        .then(({ data }) => {
          context.commit('setBoards', data);
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
    },
    getBoard(context, payload) {
      http.get(payload).then(({ data }) => {
        context.commit('setBoard', data);
      });
    },
    getNotices(context) {
      http
        .get('/notice')
        .then(({ data }) => {
          context.commit('setNotices', data);
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
    },
    getNotice(context, payload) {
      http.get(payload).then(({ data }) => {
        context.commit('setNotice', data);
      });
    },
    getQnas(context) {
      http
        .get('/qna')
        .then(({ data }) => {
          context.commit('setQnas', data);
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
    },
    getQna(context, payload) {
      http.get(payload).then(({ data }) => {
        context.commit('setQna', data);
      });
    },
    getPolicys(context) {
      http
        .get('/policy')
        .then(({ data }) => {
          context.commit('setPolicys', data);
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
    },
    getPolicy(context, payload) {
      http.get(payload).then(({ data }) => {
        context.commit('setPolicy', data);
      });
    },
    getReplys(context) {
      http
        .get('/reply')
        .then(({ data }) => {
          context.commit('setReplys', data);
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
    },
    getReply(context, payload) {
      http.get(payload).then(({ data }) => {
        context.commit('setReply', data);
      });
    },
    getGuguns(context) {
      http.get('/deal/region')
      .then(({data}) => {
        context.commit('setGuguns', data);
      })
      .catch(() => {
        alert("에러가 발생했습니다.");
      });
    },
    getDongs(context, payload) {
      http.get('/deal/region/' + payload)
      .then(({data}) => {
        context.commit('setDongs', data);
      })
      .catch(() => {
        alert("에러가 발생했습니다.");
      });
    },
    getDeals(context, payload) {
      http.post('/deal/list', payload)
      .then(({data}) => {
        context.commit('setDeals', data);
      })
      .catch(() => {
        alert("에러가 발생했습니다.");
      });
    },
    getMainc(context) {
      http.get('/deal/category')
      .then(({data}) => {
        context.commit('setMainc', data);
      })
      .catch(() => {
        alert("에러가 발생했습니다.");
      });
    },
    getMiddlec(context, payload) {
      http.get('/deal/middle/' + payload)
      .then(({data}) => {
        context.commit('setMiddlec', data);
      })
      .catch(() => {
        alert("에러가 발생했습니다.");
      });
    },
    getSubc(context, payload) {
      http.get('/deal/sub/' + payload)
      .then(({data}) => {
        context.commit('setSubc', data);
      })
      .catch(() => {
        alert("에러가 발생했습니다.");
      });
    },
    getShops(context, payload) {
      http.post('/deal/shop', payload)
      .then(({data}) => {
        context.commit('setShops', data);
      })
      .catch(() => {
        alert("에러가 발생했습니다.");
      });
    },
    getEnvs(context, payload) {
      http.get('/deal/env/' + payload)
      .then(({data}) => {
        context.commit('setEnvs', data);
      })
      .catch(() => {
        alert("에러가 발생했습니다.");
      });
    },
  },
  modules: {}
});