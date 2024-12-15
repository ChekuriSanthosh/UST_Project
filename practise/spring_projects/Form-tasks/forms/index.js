const baseUrl = "http://localhost:8080/api/v1/forms";


async function getForms() {
    const response = await fetch(baseUrl);
    const data = await response.json();
    return data;
}

async function addTask() {
    const id = document.getElementById('id').value;
    const task = {
        id: id,
        name: document.getElementById('name').value,
        description: document.getElementById('description').value,
    };

    const response = await fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(task)
    });

    if (response.ok) {
        console.log('Task added successfully!');
        document.getElementById('taskForm').reset();
        await loadForms();
    }

}

async function loadForms() {
    const tasks = await getForms();
    displayTasks(tasks);
}

function displayTasks(tasks) {
    const formCards = document.getElementById('formCards');
    formCards.innerHTML = ''; 
    tasks.forEach(task => {
        const card = document.createElement('div');
        card.className = 'box col-md-3';
        card.innerHTML = `
            <div class="card m-3">
                <div class="card-body">
                    <h5 class="card-title">Name: ${task.name}</h5>
                    <p class="card-text">${task.description}</p>
                </div>
            </div>`;
        formCards.appendChild(card);
    });
}


loadForms();
