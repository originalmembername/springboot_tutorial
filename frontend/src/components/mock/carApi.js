/* eslint-disable */
const id = () => Math.floor(Math.random() * 100)

export default {

    ['GET */cars'](pathMatch, query, request) {
        let body = {
            cars: [
                {
                    id: id(), brand: 'Mercedes', model: 'SLK', src: 'https://www.autoscout24.de/assets/auto/images/model/mercedes-benz/mercedes-benz-slk-200/mercedes-benz-slk-200-l-01.jpg'
                },
                {
                    id: id(), brand: 'Volkswagen', model: 'Golf', src: 'https://www.volkswagen.de/content/dam/vw-ngw/international-mastersite/showrooms/golf-2016/content/showroom-stage/GL4709_7-8-front_male-model.jpg/_jcr_content/renditions/original.transform/max/img.jpg'
                }
            ]
        }

        return {
            body: body,
            status: 200
        }
    }
}