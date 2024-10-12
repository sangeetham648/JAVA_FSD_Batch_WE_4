const events = [
    { id: 1, name: 'Event 1', availableSeats: 50, description: 'Description for Event 1' },
    { id: 2, name: 'Event 2', availableSeats: 30, description: 'Description for Event 2' },
    { id: 3, name: 'Event 3', availableSeats: 20, description: 'Description for Event 3' },
    { id: 4, name: 'Event 4', availableSeats: 40, description: 'Description for Event 4' },
    { id: 5, name: 'Event 5', availableSeats: 25, description: 'Description for Event 5' },
    { id: 6, name: 'Event 6', availableSeats: 35, description: 'Description for Event 6' }
];

function displayEvents(eventList) {
    const eventListDiv = document.getElementById('event-list');
    eventListDiv.innerHTML = '';

    eventList.forEach(event => {

        const eventItemWrapper = document.createElement('div');
        eventItemWrapper.className = 'event-item';
        eventItemWrapper.dataset.eventId = event.id;

        const eventItem = document.createElement('div');
        eventItem.className = 'event-item-list';

        const eventName = document.createElement('h2');
        eventName.textContent = event.name;

        const eventDescription = document.createElement('p');
        eventDescription.textContent = event.description;

        const eventSeats = document.createElement('p');
        eventSeats.textContent = `Available Seats: ${event.availableSeats}`;

        const profileDiv = document.createElement('div');
        profileDiv.className = 'profile';

        const imgElement = document.createElement('img');
        imgElement.src = './6515859.webp';
        imgElement.alt = 'Profile Image';

        profileDiv.appendChild(imgElement);

        eventItemWrapper.appendChild(profileDiv);
        eventItem.appendChild(eventName);
        eventItem.appendChild(eventDescription);
        eventItem.appendChild(eventSeats);
        eventItemWrapper.appendChild(eventItem);

        eventItemWrapper.addEventListener('click', () => showRegistrationForm(event));

        eventItemWrapper.dataset.eventId = event.id;

        eventListDiv.appendChild(eventItemWrapper);

    });
}

document.getElementById('search-bar').addEventListener('input', function(e) {
    const searchTerm = e.target.value.toLowerCase();
    const filteredEvents = events.filter(event => event.name.toLowerCase().includes(searchTerm));
    displayEvents(filteredEvents);
});

function showRegistrationForm(event) {
    document.getElementById('registration-container').style.display = 'block';
    document.getElementById('registration-title').textContent = `Register for ${event.name}`;
    document.getElementById('number-of-seats').max = event.availableSeats;
}

document.getElementById('registration-form').addEventListener('submit', function(event) {
    event.preventDefault();
    alert('Form submitted!');
    document.getElementById('registration-container').style.display = 'none';
    // Add logic to handle form data here
});

document.getElementById('cancel-button').addEventListener('click', function() {
    document.getElementById('registration-form').reset();
    document.getElementById('registration-container').style.display = 'none';
});

// Initial display of events
displayEvents(events);
