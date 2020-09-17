<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <router-link to="/" class="nav-link">HOME</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/deal/list" class="nav-link">주택정보</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/qna" class="nav-link">질문게시판</router-link>
        </li>
        <li class="nav-item">
          <!-- <a class="nav-link" href="#">공지사항</a> -->
          <router-link to="/notice" class="nav-link">공지사항</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/policy" class="nav-link">주택관련 정책</router-link>
        </li>
      </ul>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <div v-if="this.$session.get('id') != null">
            <a v-b-modal.modal-memberInfo>회원정보</a>
          </div>
        </li>
        <li class="nav-item">
          <div>
            <div v-if="this.$session.get('id') == null">
              <a v-b-modal.modal-1>로그인</a>
            </div>
            <div v-else-if="this.$session.get('id') != null">
              <a v-on:click="sessionDistroy" style="cursor:pointer;">로그아웃</a>
            </div>

            <b-modal id="modal-1" title="로그인" hide-footer>
              <div class="modal-body">
                <form @submit.prevent>
                  <div class="form-group">
                    <input
                      type="text"
                      class="form-control"
                      id="id"
                      ref="id"
                      placeholder="ID를 입력하세요"
                      v-model="id"
                    />
                  </div>
                  <div class="form-group">
                    <input
                      type="passward"
                      class="form-control"
                      id="pw"
                      ref="pw"
                      placeholder="PW를 입력하세요"
                      v-model="pw"
                    />
                  </div>
                  <div class="form-group">
                    <button
                      class="btn btn-primary btn-lg btn-block login-btn"
                      @click="checkHandlerLogin"
                    >로그인</button>
                  </div>
                </form>
              </div>

              <b-button class="btn btn-primary" v-b-modal.modal-multi-1>아이디 찾기</b-button>
              <b-button class="btn btn-primary" v-b-modal.modal-multi-2>비밀번호 찾기</b-button>
              <b-button class="btn btn-primary" v-b-modal.modal-multi-3>회원가입</b-button>
            </b-modal>
            <b-modal id="modal-multi-1" title="아이디찾기" hide-footer>
              <p class="my-2">아이디찾기</p>
            </b-modal>
            <b-modal id="modal-multi-2" title="비밀번호찾기" hide-footer>
              <p class="my-2">비밀번호찾기</p>
            </b-modal>
            <b-modal id="modal-multi-3" title="회원가입" hide-footer>
              <div class="modal-body">
                <div class="form-group">
                  <label>아이디 :</label>
                  <input
                    type="text"
                    class="form-control"
                    id="id"
                    ref="id"
                    placeholder="ID를 입력하세요"
                    v-model="id"
                  />
                </div>
                <div class="form-group">
                  <label>비밀번호 :</label>
                  <input
                    type="password"
                    class="form-control"
                    id="pw"
                    ref="pw"
                    placeholder="PW를 입력하세요"
                    v-model="pw"
                  />
                </div>
                <div class="form-group">
                  <label>이름 :</label>
                  <input
                    type="text"
                    class="form-control"
                    id="name"
                    ref="name"
                    placeholder="name을 입력하세요"
                    v-model="name"
                  />
                </div>
                <div class="form-group">
                  <label>이메일 :</label>
                  <input
                    type="text"
                    class="form-control"
                    id="email"
                    ref="email"
                    placeholder="email을 입력하세요"
                    v-model="email"
                  />
                </div>
                <div class="form-group">
                  <label>주소 :</label>
                  <input
                    type="text"
                    class="form-control"
                    id="address"
                    ref="address"
                    placeholder="address를 입력하세요"
                    v-model="address"
                  />
                </div>
                <div class="form-group">
                  <label>핸드폰번호 :</label>
                  <input
                    type="text"
                    class="form-control"
                    id="phone"
                    ref="phone"
                    placeholder="phone을 입력하세요"
                    v-model="phone"
                  />
                </div>
                <div class="form-group">
                  <button
                    class="btn btn-primary btn-lg btn-block login-btn"
                    @click="checkHandlerInsert"
                  >회원가입</button>
                </div>
              </div>
            </b-modal>

            <b-modal id="modal-memberInfo" title="회원정보" hide-footer>
              <div class="form-group">
                <label>아이디 :</label>
                <br />
                <div v-text="this.$session.get('id')"></div>
              </div>
              <div class="form-group">
                <label>비밀번호 :</label>
                <input
                  type="password"
                  class="form-control"
                  id="pw"
                  ref="pw"
                  placeholder="비밀번호를 입력하세요"
                  v-model="pw"
                />
              </div>
              <div class="form-group">
                <label>비밀번호 확인 :</label>
                <input
                  type="password"
                  class="form-control"
                  id="pw_re"
                  ref="pw_re"
                  placeholder="비밀번호 한번 더 입력하세요"
                  v-model="pw_re"
                />
              </div>
              <div class="form-group">
                <label>이름 :</label>
                <input
                  type="text"
                  class="form-control"
                  id="name"
                  ref="name"
                  placeholder="name을 입력하세요"
                  v-model="name"
                />
              </div>
              <div class="form-group">
                <label>이메일 :</label>
                <input
                  type="text"
                  class="form-control"
                  id="email"
                  ref="email"
                  placeholder="email을 입력하세요"
                  v-model="email"
                />
              </div>
              <div class="form-group">
                <label>주소 :</label>
                <input
                  type="text"
                  class="form-control"
                  id="address"
                  ref="address"
                  placeholder="address를 입력하세요"
                  v-model="address"
                />
              </div>
              <div class="form-group">
                <label>핸드폰번호 :</label>
                <input
                  type="text"
                  class="form-control"
                  id="phone"
                  ref="phone"
                  placeholder="phone을 입력하세요"
                  v-model="phone"
                />
              </div>
              <div class="form-group">
                <button class="btn btn-primary" @click="checkHandlerModify">회원정보수정</button>
              </div>
              <div class="form-group">
                <button class="btn btn-primary" @click="deleteHandler">회원탈퇴</button>
              </div>
            </b-modal>
          </div>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
import http from "@/util/http-common";
export default {
  name: "AppHeader",
  props: {
    type: { type: String }
  },
  data: function() {
    return {
      id: this.$session.get("id"),
      pw: "",
      pw_re: "",
      name: this.$session.get("name"),
      email: this.$session.get("email"),
      address: this.$session.get("address"),
      phone: this.$session.get("phone"),
      joindate: this.$session.get("joindate")
    };
  },
  methods: {
    checkHandlerLogin() {
      let err = true;
      let msg = "";
      !this.id &&
        ((msg = "아이디를 입력해주세요"), (err = false), this.$refs.id.focus());
      err &&
        !this.pw &&
        ((msg = "비밀번호를 입력해주세요"),
        (err = false),
        this.$refs.pw.focus());

      if (!err) alert(msg);
      else this.loginHandler();
    },
    checkHandlerInsert() {
      let err = true;
      let msg = "";
      !this.id &&
        ((msg = "아이디를 입력해주세요"), (err = false), this.$refs.id.focus());
      err &&
        !this.pw &&
        ((msg = "비밀번호를 입력해주세요"),
        (err = false),
        this.$refs.pw.focus());
      err &&
        !this.name &&
        ((msg = "이름을 입력해주세요"), (err = false), this.$refs.name.focus());
      err &&
        !this.email &&
        ((msg = "이메일을 입력해주세요"),
        (err = false),
        this.$refs.email.focus());
      err &&
        !this.address &&
        ((msg = "주소를 입력해주세요"),
        (err = false),
        this.$refs.address.focus());
      err &&
        !this.phone &&
        ((msg = "핸드폰번호를 입력해주세요"),
        (err = false),
        this.$refs.phone.focus());

      if (!err) alert(msg);
      else this.insertHandler();
    },

    checkHandlerModify() {
      let err = true;
      let msg = "";
      !this.pw &&
        ((msg = "비밀번호를 입력해주세요"),
        (err = false),
        this.$refs.pw.focus());
      err &&
        !this.pw_re &&
        ((msg = "재입력 비밀번호를 입력해주세요"),
        (err = false),
        this.$refs.pw_re.focus());
      err &&
        !this.name &&
        ((msg = "이름을 입력해주세요"), (err = false), this.$refs.name.focus());
      err &&
        !this.email &&
        ((msg = "이메일을 입력해주세요"),
        (err = false),
        this.$refs.email.focus());
      err &&
        !this.address &&
        ((msg = "주소를 입력해주세요"),
        (err = false),
        this.$refs.address.focus());
      err &&
        !this.phone &&
        ((msg = "핸드폰번호를 입력해주세요"),
        (err = false),
        this.$refs.phone.focus());
      err &&
        this.pw != this.pw_re &&
        ((msg = "비밀번호와 재입력 비밀번호가 다릅니다."),
        (err = false),
        this.$refs.pw_re.focus());

      if (!err) alert(msg);
      else this.modifyHandler();
    },

    loginHandler() {
      http
        .get(`/member/${this.id}`)
        .then(({ data }) => {
          if (this.pw == data.pw) {
            this.id = data.id;
            this.pw = data.pw;
            this.name = data.name;
            this.email = data.email;
            this.address = data.address;
            this.phone = data.phone;
            this.joindate = data.joindate;
            alert("로그인이 성공했습니다.");
            this.$root.$emit("bv::hide::modal", "modal-1");
            if (this.name != null) {
              this.$session.set("id", this.id);
              this.$session.set("pw", this.pw);
              this.$session.set("name", this.name);
              this.$session.set("email", this.email);
              this.$session.set("address", this.address);
              this.$session.set("phone", this.phone);
              this.$session.set("joindate", this.joindate);
            } else {
              alert("실패");
            }
          } else {
            alert("로그인이 실패했습니다.");
          }
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
    sessionDistroy() {
      this.$session.destroy();
      this.$router.go();
      this.id = "";
      this.pw = "";
      this.name = "";
      this.email = "";
      this.address = "";
      this.phone = "";
      this.joindate = "";
    },

    insertHandler() {
      http
        .post(`/member`, {
          id: this.id,
          pw: this.pw,
          name: this.name,
          email: this.email,
          address: this.address,
          phone: this.phone
        })
        .then(({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
          this.$root.$emit("bv::hide::modal", "modal-multi-3");
        })
        .catch(() => {
          alert("등록 처리시 에러가 발생했습니다.");
        });

      this.id = null;
      this.pw = null;
      this.name = null;
      this.email = null;
      this.address = null;
      this.phone = null;
    },
    modifyHandler() {
      http
        .put(`/member/${this.$session.get("id")}`, {
          id: this.$session.get("id"),
          pw: this.pw,
          name: this.name,
          email: this.email,
          address: this.address,
          phone: this.phone
        })
        .then(({ data }) => {
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "수정이 완료되었습니다.";
          }
          this.$root.$emit("bv::hide::modal", "modal-memberInfo");
          alert(msg);
        })
        .catch(() => {
          alert("수정 처리시 에러가 발생했습니다.");
        });
    },
    deleteHandler() {
      http
        .delete(`/member/${this.$session.get("id")}`)
        .then(({ data }) => {
          let msg = "삭제 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "삭제가 완료되었습니다.";
          }
          this.$root.$emit("bv::hide::modal", "modal-memberInfo");
          alert(msg);
          this.$session.destroy();
          this.$router.go();
        })
        .catch(() => {
          alert("삭제 처리시 에러가 발생했습니다.");
        });
    }
  }
};
</script>
<style>
a {
  margin: 5px;
}
</style>