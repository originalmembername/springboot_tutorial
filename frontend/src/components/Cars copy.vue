<template>
  <v-layout row wrap>
    <v-flex v-for="car in cars" :key="car.id" v-bind="{ [`xs3`]: true }">
      <v-card>
        <v-img :src="car.imgUrl" height="100px">
          <v-container fill-height fluid pa-2>
            <v-layout fill-height>
              <v-flex xs12 align-end flexbox>
                <span class="headline white--text" v-text="`${car.brand} ${car.model}`"></span>
              </v-flex>
            </v-layout>
          </v-container>
        </v-img>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn icon>
            <v-icon>favorite</v-icon>
          </v-btn>
          <v-btn icon>
            <v-icon>bookmark</v-icon>
          </v-btn>
          <v-btn icon>
            <v-icon>share</v-icon>
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-flex>
  </v-layout>
</template>

<script>
export default {
  data: () => ({
    cars: []
  }),
  methods: {
    loadCars() {
      this.$http
        .get(`http://localhost:8090/api/v1/car`)
        // .get(`${process.env.API_HOST}/cars`)
        .then(response => {
          // let {cars} = response.body;
          let cars = response.body;
          this.cars = cars;
        });
    }
  },
  beforeMount() {
    this.loadCars();
  }
};
</script>

