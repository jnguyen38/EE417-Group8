document.getElementById('contact-form').addEventListener('submit', async function (event) {
    event.preventDefault();
    
    const formData = new FormData(event.target);
    const contact = {
        firstname: formData.get('firstname'),
        lastname: formData.get('lastname'),
        email: formData.get('email'),
        phone: formData.get('phone'),
        message: formData.get('message')
    };

    try {
        const response = await fetch('/api/contacts', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(contact)
        });

		if (response.ok) {
		    const result = await response.text();
		    alert(result);
		} else {
		    const error = await response.json();
		    let errorMessage = 'Error submitting form:';
		    for (const [key, value] of Object.entries(error)) {
		        errorMessage += `\n${key}: ${value}`;
		    }
		    alert(errorMessage);
		}
    } catch (error) {
        alert('Error submitting form');
    }
});
