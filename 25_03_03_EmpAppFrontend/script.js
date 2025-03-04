let employees = [];
let nextId = 1;

function loadDashboard() {
    document.getElementById('welcomeScreen').style.display = 'none';
    document.getElementById('dashboard').style.display = 'block';
}

function showEmployees() {
    document.querySelectorAll('form, #updateDetails, #removeDetails').forEach(el => el.style.display = 'none');
    document.getElementById('searchResult').innerHTML = '';
    let list = document.getElementById('employeeList');
    list.innerHTML = Object.entries(employees)
        .filter(([id, emp]) => emp !== null)
        .map(([id, emp]) => `<p>${id}: ${emp.name} - ${emp.position}</p>`)
        .join('');
    list.style.display = 'block';
}

function toggleForm(formId) {
    document.querySelectorAll('form, #updateDetails, #removeDetails').forEach(el => el.style.display = 'none');
    document.getElementById(formId).style.display = 'block';
    document.getElementById('employeeList').style.display = 'none';
    document.getElementById('searchResult').innerHTML = '';
}

function addEmployee(event) {
    event.preventDefault();
    let name = document.getElementById('addName').value;
    let position = document.getElementById('addPosition').value;
    employees[nextId] = { name, position };
    nextId++;
    event.target.reset();
}

function searchEmployee(event) {
    event.preventDefault();
    let searchId = document.getElementById('searchId').value;
    let emp = employees[searchId];
    document.getElementById('searchResult').innerHTML = emp 
        ? `<p>${searchId}: ${emp.name} - ${emp.position}</p>` 
        : "<p>Employee not found</p>";
    event.target.reset();
}

function fetchUpdateEmployee() {
    let updateId = document.getElementById('updateIdInput').value;
    let emp = employees[updateId];
    if (emp) {
        document.getElementById('updateName').value = emp.name;
        document.getElementById('updatePosition').value = emp.position;
        document.getElementById('updateForm').style.display = 'block';
    } else {
        alert("Employee not found");
    }
}

function updateEmployee(event) {
    event.preventDefault();
    let updateId = document.getElementById('updateIdInput').value;
    employees[updateId].name = document.getElementById('updateName').value;
    employees[updateId].position = document.getElementById('updatePosition').value;
    event.target.reset();
}

function confirmRemoveEmployee() {
    let removeId = document.getElementById('removeIdInput').value;
    let emp = employees[removeId];
    if (emp) {
        document.getElementById('removeEmployeeInfo').innerText = `Remove ${emp.name} - ${emp.position}?`;
        document.getElementById('removeConfirmation').style.display = 'block';
    } else {
        alert("Employee not found");
    }
}

function removeEmployee() {
    let removeId = document.getElementById('removeIdInput').value;
    employees[removeId] = null;
    document.getElementById('removeConfirmation').style.display = 'none';
}

function cancelRemove() {
    document.getElementById('removeConfirmation').style.display = 'none';
}