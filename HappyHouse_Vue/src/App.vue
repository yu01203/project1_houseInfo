<template>
  <div class="container">
    <nav-header></nav-header>
    
    <br>
    <router-view></router-view>
    <Footer></Footer>

  </div>
</template>

<script>
import NavHeader from '@/components/Header.vue';
import Footer from '@/components/Footer.vue';


export default {
  name: 'App',
  components: {
    NavHeader,
    Footer
  },
};
</script>
<style>
.container img{
  display: block;
  margin: 0px auto;
  width: 100%;
  height: auto;
}
</style>