const orderId = document.getElementById("orderId");
const orderTable = document.getElementById("orderTable");

const params = new Proxy(new URLSearchParams(window.location.search), {
    get: (searchParams, prop) => searchParams.get(prop),
});

let queryId = params["id"];

function addRow(item, quantity, cost) {
    // Create an empty <tr> element
    console.log(orderTable.rows.length)
    let row = orderTable.insertRow(orderTable.rows.length - 1);

    // Insert new cells to the corresponding columns of the table
    let tableName = row.insertCell(0);
    let tableQuantity = row.insertCell(1);
    let tableCost = row.insertCell(2);
    let tableTotalCost = row.insertCell(3);

    // Add text to the table data
    tableName.innerHTML = `<p class="fw-2">${item}</p>`
    tableQuantity.innerHTML = `<p class="fw-2">${quantity}</p>`
    tableCost.innerHTML = `<p class="fw-2">&euro; ${cost}.00</p>`;
    tableTotalCost.innerHTML = `<p class="fw-2">&euro; ${cost * quantity}.00</p>`;
}

if (queryId) {
    let total = 0;

    orderId.innerHTML = queryId;

    let finalRow = orderTable.insertRow(orderTable.rows.length);
    let finalName = finalRow.insertCell(0);
    finalRow.insertCell(1);
    finalRow.insertCell(2);
    let finalTotal = finalRow.insertCell(3);

    finalName.innerHTML = `<p class="fw-7">Total Cost</p>`;

    fetch(`/api/orders/find/${parseInt(queryId)}`)
        .then(res => res.json())
        .then(data => {
            Object.keys(data.items).map(item => {
                fetch(`/api/items/getCost/${item}`)
                    .then(innerRes => innerRes.json())
                    .then(cost => {
                        let quantity = data.items[item];
                        addRow(item, quantity, cost)
                        total += cost * quantity;
                        finalTotal.innerHTML = `<p class="fw-7">&euro; ${total}.00</p>`;
                    });
            });
        });
}