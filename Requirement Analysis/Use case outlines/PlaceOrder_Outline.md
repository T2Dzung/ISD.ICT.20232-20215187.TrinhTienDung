# Use Case Outline

## Use case "Place Order"
- Basic Flow of the event

Step 1: Customer reviews the cart and select the products they want to purchase <br />
Step 2: Customer requests to place an order <br />
Step 3: Software checks the order <br />
Step 4: Customers sets up delivery information  <br />
Step 5: Software checks the input information  <br />
Step 6: Customer selects order delivery options: rush order delivery or default order delivery <br />
Step 7: Software checks the delivery method <br />
Step 8: Software calculates the payment and displays to customer <br />
Step 9: Customers selects a payment method <br />
Step 10: Software sends order and transaction information to the customer's email <br />
Step 11: Customer accepts the order  <br />
Step 12: Product manager approves the order <br />
Step 13: Software checks the order again <br />
Step 14: Place order successfully <br />

- Alternative flows of the event

Step 3A: If the inventory quantity is insufficient, software will ask customers to update the cart (go back to Step 1) <br />
Step 5A: If there are any required fields left blank or invalid information, software will ask customers to update information (go back to Step 4) <br />
Step 7A: If customer chooses rush order delivery method then check if the order is eligible for the method. If false, software will ask customer to update the delivery information or delivery method (go back to Step 4). If true, requests additional rush order delivery information from the customer (then to Step 8) <br />
Step 9A: If customer selects VNPay, customer need to provide the necessary information as requested by VNPay (then go to Step 10) <br />
Step 11A: If customer cancels order, payment will be refunded (end use case) <br />
Step 12A: If product manager rejects the order, payment will be refunded (end use case) <br />
Step 13A: If software rejects the order, payment will be refunded (end use case) <br />
