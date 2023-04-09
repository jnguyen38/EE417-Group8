// get references to the relevant DOM elements
const menuTable = document.querySelector('.menu-table');
const orderTable = document.querySelector('.table-order');
const orderButton = document.querySelector('button[type="button"]');

// create a new function to handle adding items to the order
function addToOrder(productName, price) {
  // check if the product is already in the order
  const existingRow = Array.from(orderTable.rows).find(row => row.cells[0].textContent === productName);
  if (existingRow) {
    // increment the quantity
    const quantityCell = existingRow.cells[2];
    quantityCell.textContent = Number(quantityCell.textContent) + 1;
  } 
  else {
    // create a new row for the order table
    const newRow = document.createElement('tr');

    // create the cells for the row
    const productCell = document.createElement('td');
    const priceCell = document.createElement('td');
    const quantityCell = document.createElement('td');
    const removeCell = document.createElement('td');
    const reduceCell = document.createElement('td');

    // set the text content for the cells
    productCell.textContent = productName;
    priceCell.textContent = "\u20AC"+price;
    quantityCell.textContent = "1";
    reduceCell.innerHTML = '<button class="reduce"style="width: 25px;" type="button">-</button>';
    removeCell.innerHTML = '<button class="remove" type="button">X</button>';
    
    // add event listeners to the buttons
    removeCell.querySelector('button').addEventListener('click', () => {
      newRow.remove();
    });
    reduceCell.querySelector('button').addEventListener('click', () => {
      const quantity = Number(quantityCell.textContent);
      if (quantity > 1) {
        quantityCell.textContent = quantity - 1;
      } else {
        newRow.remove();
      }
    });

    // add the cells to the row
    newRow.appendChild(productCell);
    newRow.appendChild(priceCell);
    newRow.appendChild(quantityCell);
    newRow.appendChild(reduceCell);
    newRow.appendChild(removeCell);
    

    // add the row to the order table
    orderTable.appendChild(newRow);
  }
}

  

// add an event listener to the menu table
menuTable.addEventListener('click', (event) => {
  // check if the event target was a button
  if (event.target.tagName === 'BUTTON') {

    const orderTable = document.querySelector('.table-order');
    orderTable.style.display = 'block';

    // get the product name and price from the table row
    const productName = event.target.parentNode.parentNode.querySelector('.Product').textContent;
    const price = event.target.parentNode.parentNode.querySelector('.Price').textContent;

    // remove the euro symbol from the price and convert it to a number
    const numericPrice = Number(price.replace(/[^0-9.-]+/g, ''));

    // add the item to the order
    addToOrder(productName, numericPrice);       
  }
});

// add an event listener to the order button
orderButton.addEventListener('click', () => {
  // alert the user that their order has been placed
  alert('Your order has been placed! Your order will be ready within 30 mins');
  orderTable.style.display = "none";
  
});
