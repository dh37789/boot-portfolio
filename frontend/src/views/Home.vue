<template>
  <div>
    <hero></hero>
    <Profile></Profile>
  </div>
</template>

<script>
import Hero from "./components/Hero";
import Profile from "./Profile.vue";

export default {
  name: "portfolioMain",
  components: {
    Hero,
    Profile
  }
}
</script>

