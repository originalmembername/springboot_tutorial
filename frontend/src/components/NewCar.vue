<template>
  <v-container grid-list-xl>
    <v-form v-model="valid">
      <v-container grid-list-xl>
        <v-layout wrap>
          <v-flex xs12 md4>
            <v-text-field v-model="brand" :rules="nameRules" :counter="20" label="Brand" required></v-text-field>
          </v-flex>

          <v-flex xs12 md4>
            <v-text-field v-model="model" :rules="nameRules" :counter="20" label="Model" required></v-text-field>
          </v-flex>
        </v-layout>
        <v-btn class="mr-4" @click="submit">submit</v-btn>
      </v-container>
    </v-form>
    <v-container fluid grid-list sm>
      <v-flex d-flex sm12>
          <v-layout wrap>
            <v-flex sm6>
              <v-card>
                <v-img
                  :src="mainImg"
                  style="border: 2px solid grey"
                ></v-img>
              </v-card>
            </v-flex>
            <v-flex sm2>
                <v-layout column>
                  <v-flex v-for="image in images" :key="image" sm1 @click="changeImg(image)">
                    <v-img class="thumbnail" :src="image" max-height="70px" max-width="100px" style="border:2px solid grey"
                    ></v-img>
                  </v-flex>
                </v-layout>
            </v-flex>
          </v-layout>
      </v-flex>
    </v-container>
  </v-container>
</template>

<script>
/* eslint-disable */
import axios from "axios";

export default {
  data: () => ({
    valid: false,
    brand: "",
    model: "",
    nameRules: [
      v => !!v || "This field is required",
      v => v.length <= 20 || "This field must be less than 20 characters"
    ],
    images: [
      "https://www.vwmanhattan.com/assets/stock/colormatched_02/white/640/cc_2018vwc230001_02_640/cc_2018vwc230001_02_640_2t2t.jpg?height=400",
      "https://upload.wikimedia.org/wikipedia/commons/5/5c/2017_Volkswagen_Golf_%285G_MY17%29_1.4_SE_TSI_hatchback_%282017-08-30%29.jpg",
      "https://cdn.meinauto.de/car-pics/___Pix-NoBrand/VOLKSWAGEN/GolfVariant/7/5Wagon%20Trendline/volkswagen_17golfvarnttrendes7fb_angularfront_nb-298.jpg"
    ],
    mainImg: "https://cdn.meinauto.de/car-pics/___Pix-NoBrand/VOLKSWAGEN/GolfVariant/7/5Wagon%20Trendline/volkswagen_17golfvarnttrendes7fb_angularfront_nb-298.jpg"
  }),

  methods: {
    submit() {
      if (this.valid) {
        axios
          .request("https://pixabay.com/api/", {
            method: "get",
            params: {
              key: "13199466-27d2c444fb6b20f46562bd57c",
              image_type: "photo",
              q: `${this.brand} ${this.model}`
            }
          })
          .then(response => {
            // JSON responses are automatically parsed.
            console.log(response.data);
            this.images = [
              "https://www.vwmanhattan.com/assets/stock/colormatched_02/white/640/cc_2018vwc230001_02_640/cc_2018vwc230001_02_640_2t2t.jpg?height=400",
              "https://upload.wikimedia.org/wikipedia/commons/5/5c/2017_Volkswagen_Golf_%285G_MY17%29_1.4_SE_TSI_hatchback_%282017-08-30%29.jpg",
              "https://cdn.meinauto.de/car-pics/___Pix-NoBrand/VOLKSWAGEN/GolfVariant/7/5Wagon%20Trendline/volkswagen_17golfvarnttrendes7fb_angularfront_nb-298.jpg"
            ];
          });
      }
    },
    changeImg(image){
      this.mainImg = image
    }
  }
};
</script>

<style>
  .thumbnail:hover {
    opacity: 0.5;
  }
</style>


