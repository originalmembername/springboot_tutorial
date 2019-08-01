<template>
  <v-container fluid grid-list-sm>
    <v-layout wrap>
      <v-flex d-flex sm4>
        <v-card>
          <v-img
            :src="`https://cdn3.iconfinder.com/data/icons/modifiers-add-on-1/48/v-01-512.png`"
            height="120px"
            style="margin:5px"
          ></v-img>
          <v-card-text style="font-size: 30px">New car</v-card-text>
        </v-card>
      </v-flex>
      <v-flex d-flex sm8>
        <v-layout wrap>
          <v-flex v-for="n in numCars1stSec" :key="n" d-flex sm3>
            <v-card flat tile>
              <v-img :src="cars[n-1].imgUrl" height="100px">
                <div class="heading" style="color:white">{{cars[n-1].brand}} {{cars[n-1].model}}</div>
              </v-img>
            </v-card>
          </v-flex>
        </v-layout>
      </v-flex>
      <v-layout v-if="numCars2ndSec > 0" wrap>
        <v-flex v-for="n in numCars2ndSec" :key="n" d-flex sm2>
          <v-card flat tile>
            <v-img :src="cars[numCars1stSec+n-1].imgUrl" height="100px">
              <div class="heading" style="color:white">{{cars[numCars1stSec+n-1].brand}} {{cars[numCars1stSec+n-1].model}}</div>
            </v-img>
          </v-card>
        </v-flex>
      </v-layout>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    cars: [],
    lorem: `Lorem ipsum dolor sit amet, mel at clita quando. Te sit oratio vituperatoribus, nam ad ipsum posidonium mediocritatem, explicari dissentiunt cu mea. Repudiare disputationi vim in, mollis iriure nec cu, alienum argumentum ius ad. Pri eu justo aeque torquatos.`,
    numCars1stSec: 0,
    numCars2ndSec: 0
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
          this.numCars1stSec = Math.min(8, cars.length);
          this.numCars2ndSec = cars.length - this.numCars1stSec;
        });
    }
  },
  beforeMount() {
    this.loadCars();
  }
};
</script>

