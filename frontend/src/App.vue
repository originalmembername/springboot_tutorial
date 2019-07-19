<template>
  <AppFrame></AppFrame>
</template>

<script>
import AppFrame from './components/AppFrame'

export default {
  name: "App",
  components: {AppFrame,},
  data() {
    return {
      //
    };
  },
  methods: {
    goTo(route) {
      this.$router.push(route);
    }
  }
};
</script>
