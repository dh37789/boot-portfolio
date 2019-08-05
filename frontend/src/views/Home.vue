<template>
  <div>
    <hero></hero>
    <Profile></Profile>
    <Stack></Stack>
  </div>
</template>

<script>
import Hero from "./components/Hero";
import Profile from "./Profile.vue";
import Stack from "./Stack.vue";

export default {
  name: "portfolioMain",
  components: {
    Hero,
    Profile,
    Stack
  }
}
</script>

