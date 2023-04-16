const userSelect = document.getElementById('userSelect');
const feedbackSelect = document.getElementById('feedbackSelect');
const messageSelect = document.getElementById('messageSelect');
const userTable = document.getElementById('userTable');
const feedbackTable = document.getElementById('feedbackTable');
const messageTable = document.getElementById('messageTable');

function addFeedback(feedback) {
    // Create an empty <tr> element
    let row = feedbackTable.insertRow(feedbackTable.rows.length);

    // Insert new cells to the corresponding columns of the table
    let orderId = row.insertCell(0);
    let rating = row.insertCell(1);
    let message = row.insertCell(2);

    orderId.innerHTML = `<p class="fw-3 fs-xs">${feedback.id}</p>`
    rating.innerHTML = `<p class="fw-3 fs-xs">${feedback.rating}</p>`
    message.innerHTML = `<p class="fw-3 fs-xs">${feedback.message}</p>`
}

function addMessage(message) {
    // Create an empty <tr> element
    let row = messageTable.insertRow(messageTable.rows.length);

    // Insert new cells to the corresponding columns of the table
    let name = row.insertCell(0);
    let email = row.insertCell(1);
    let number = row.insertCell(2);
    let text = row.insertCell(3);

    name.innerHTML = `<p class="fw-3 fs-xs">${message.firstName + " " + message.lastName}</p>`
    email.innerHTML = `<p class="fw-3 fs-xs">${message.email}</p>`
    number.innerHTML = `<p class="fw-3 fs-xs">${message.number}</p>`
    text.innerHTML = `<p class="fw-3 fs-xs">${message.message}</p>`
}

function addUser(user) {
    // Create an empty <tr> element
    let row = userTable.insertRow(userTable.rows.length);

    // Insert new cells to the corresponding columns of the table
    let name = row.insertCell(0);
    let email = row.insertCell(1);
    let number = row.insertCell(2);
    let address = row.insertCell(3);
    let role = row.insertCell(4);
    let password = row.insertCell(5);

    name.innerHTML = `<p class="fw-3 fs-xs">${user.firstName + " " + user.lastName}</p>`
    email.innerHTML = `<p class="fw-3 fs-xs">${user.email}</p>`
    number.innerHTML = `<p class="fw-3 fs-xs">${user.number}</p>`
    address.innerHTML = `<p class="fw-3 fs-xs">${user.address + " " + user.eircode}</p>`
    role.innerHTML = `<p class="fw-3 fs-xs">${user.role}</p>`
    password.innerHTML = `<p class="fw-3 fs-xs">${user.password}</p>`
}

function removeSelectAttr() {
    userSelect.classList.remove('clicked');
    feedbackSelect.classList.remove('clicked');
    messageSelect.classList.remove('clicked');
}

function hideTables() {
    userTable.style.display = "none";
    feedbackTable.style.display = "none";
    messageTable.style.display = "none";
}

userSelect.addEventListener('click', () => {
    removeSelectAttr();
    hideTables();
    userSelect.classList.add('clicked');
    userTable.style.display = "table";
});

feedbackSelect.addEventListener('click', () => {
    removeSelectAttr();
    hideTables();
    feedbackSelect.classList.add('clicked');
    feedbackTable.style.display = "table";
});

messageSelect.addEventListener('click', () => {
    removeSelectAttr();
    hideTables();
    messageSelect.classList.add('clicked');
    messageTable.style.display = "table";
});

fetch("/api/users/all")
    .then(res => res.json())
    .then(data => {
        data.map(user => {
            addUser(user);
        });
    });

fetch("/api/contacts/all")
    .then(res => res.json())
    .then(data => {
        data.map(message => {
            addMessage(message);
        });
    });

fetch("/api/feedback/all")
    .then(res => res.json())
    .then(data => {
        data.map(feedback => {
            addFeedback(feedback);
        });
    });