<template>
  <v-layout row wrap>
    <v-flex v-for="car in cars" :key="car.id" v-bind="{ [`xs3`]: true }">
      <v-card>
        <v-img :src="car.src" height="100px">
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
    cards: [
      {
        title: "Pre-fab homes",
        src: "https://cdn.vuetifyjs.com/images/cards/house.jpg",
        flex: 6
      },
      {
        title: "Favorite road trips",
        src: "https://cdn.vuetifyjs.com/images/cards/road.jpg",
        flex: 3
      },
      {
        title: "Best airlines",
        src: "https://cdn.vuetifyjs.com/images/cards/plane.jpg",
        flex: 3
      }
    ],
    cars: [
      {
        id: "1",
        brand: "Mercedes",
        model: "SLK",
        src: "https://www.autoscout24.de/assets/auto/images/model/mercedes-benz/mercedes-benz-slk-200/mercedes-benz-slk-200-l-01.jpg"
      },
      {
        id: "2",
        brand: "Volkswagen",
        model: "Golf",
        src: "https://www.volkswagen.de/content/dam/vw-ngw/international-mastersite/showrooms/golf-2016/content/showroom-stage/GL4709_7-8-front_male-model.jpg/_jcr_content/renditions/original.transform/max/img.jpg",
      }
    ]
  })
};
</script>

