<template>
  <div>
    <hero></hero>
    <Profile></Profile>
    <Stack></Stack>
    <Project></Project>
  </div>
</template>

<script>
import Hero from "./components/Hero";
import Profile from "./Profile.vue";
import Stack from "./Stack.vue";
import Project from "./Project.vue";

export default {
  name: "portfolioMain",
  components: {
    Hero,
    Profile,
    Stack,
    Project
  }
}
</script>

