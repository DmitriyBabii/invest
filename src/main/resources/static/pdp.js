const mainImage = document.getElementById('project-img')
const sliderImages = document.querySelectorAll('.slider>img')
const postsContainer = document.getElementById('posts')
const tariffsContainer = document.getElementById('tariffs')
const projectId = window.location.href.split('/').slice(-1)[0]

sliderImages.forEach(elem => {
    elem.onclick = () => {
        mainImage.src = elem.src
    }
})

fetch(`/api/posts/${projectId}`)
    .then((response) => response.json())
    .then((json) => {
        console.log(json)
        json.forEach(elem => {
            const post = document.createElement('div')
            const img = document.createElement('img')
            const content = document.createElement('div')

            post.className = 'post'

            img.src = elem.picture

            content.className = 'post-details'
            content.textContent = elem.content

            post.append(img)
            post.append(content)
            postsContainer.append(post)
        })
    });

fetch(`/api/tariffs/${projectId}`)
    .then((response) => response.json())
    .then((json) => {
        console.log(json)
        json.forEach(elem => {
            const tariff = document.createElement('div')
            const tariffPrice = document.createElement('div')
            const tariffDetails = document.createElement('div')
            const tariffName = document.createElement('div')
            const tariffDescription = document.createElement('div')
            const subscribeBtn = document.createElement('a')

            tariff.className = 'tarif'
            tariffPrice.className = 'tarif-price'
            tariffDetails.className = 'tarif-details'
            tariffName.className = 'tarif-name'
            tariffDescription.className = 'tarif-description'
            subscribeBtn.className = 'subscribe-tarif'
            subscribeBtn.href = '#'

            tariffPrice.textContent = elem.price
            tariffName.textContent = elem.name
            tariffDescription.textContent = elem.description
            subscribeBtn.textContent = 'Subscribe'

            tariffDetails.append(tariffName)
            tariffDetails.append(tariffDescription)
            tariff.append(tariffPrice)
            tariff.append(tariffDetails)
            tariff.append(subscribeBtn)
            tariffsContainer.append(tariff)
        })
    });