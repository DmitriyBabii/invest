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

console.log(`/api/posts/${projectId}`)

fetch(`/api/posts/${projectId}`)
    .then((response) => response.json())
    .then((json) => {
        json.forEach(elem => {
            const post = document.createElement('div')
            const img = document.createElement('img')
            //const title = document.createElement('div')
            const content = document.createElement('div')

            post.className = 'post'

            img.src = elem.picture
            //title.textContent = elem.title

            content.className = 'post-details'
            content.textContent = elem.content

            post.append(img)
            //post.append(title)
            post.append(content)
            postsContainer.append(post)
        })
    });

fetch(`/api/tariffs/${projectId}`)
    .then((response) => response.json())
    .then((json) => {
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


// <div class="tarif" th:each="tariff : *{tariffs}" th:object="${tariff}">
//         <div class="tarif-price" th:text="*{price}"></div>
//         <div class="tarif-details">
//             <div class="tarif-name">Some tarif name</div>
//             <div class="tarif-description">
//                 Lorem ipsum dolor, sit amet consectetur adipisicing elit. Quos velit recusandae asperiores
//                 voluptate optio? In at nulla nesciunt accusantium pariatur illo, cum totam assumenda excepturi
//                 inventore expedita vel quisquam provident.
//                 Odit qui molestias quo sunt, cupiditate nulla asperiores eum in dignissimos ipsa ea expedita
//                 possimus rerum accusamus eos, dolor, reprehenderit maiores. Vero animi est corporis ratione
//                 repudiandae veritatis totam doloremque?
//             </div>
//             <a href="#" class="subscribe-tarif">Subscribe</a>
//         </div>
//     </div>