const API_URL = "https://crudcrud.com/api/6eeb1efad4ea45a4a85d391500d3c8b8/empdb";

function loadDashboard() {
    document.getElementById('welcomeScreen').style.display = 'none';
    document.getElementById('dashboard').style.display = 'block';
}

async function showEmployees() {
    document.querySelectorAll('form, #updateDetails, #removeDetails').forEach(el => el.style.display = 'none');
    document.getElementById('searchResult').innerHTML = '';
    
    try {
        let response = await fetch(API_URL);
        let data = await response.json();
        let list = document.getElementById('employeeList');
        list.innerHTML = data.map(emp => `<p>${emp._id}: ${emp.name} - ${emp.position}</p>`).join('');
        list.style.display = 'block';
    } catch (error) {
        console.error("Error fetching employees:", error);
    }
}
function toggleForm(formId) {
    document.querySelectorAll('form, #updateDetails, #removeDetails').forEach(el => el.style.display = 'none');
    document.getElementById(formId).style.display = 'block';
    document.getElementById('employeeList').style.display = 'none';
    document.getElementById('searchResult').innerHTML = '';
}

async function addEmployee(event) {
    event.preventDefault();
    let name = document.getElementById('addName').value;
    let position = document.getElementById('addPosition').value;
    
    try {
        await fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ name, position })
        });
        event.target.reset();
        console.log("Added employee");
        // showEmployees();
    } catch (error) {
        console.error("Error adding employee:", error);
    }
}

async function searchEmployee(event) {
    event.preventDefault();
    let searchId = document.getElementById('searchId').value;
    
    try {
        let response = await fetch(API_URL);
        let data = await response.json();
        let emp = data.find(emp => emp._id === searchId);
        document.getElementById('searchResult').innerHTML = emp 
            ? `<p>${emp._id}: ${emp.name} - ${emp.position}</p>` 
            : "<p>Employee not found</p>";
    } catch (error) {
        console.error("Error searching employee:", error);
    }
    event.target.reset();
}

async function fetchUpdateEmployee() {
    let updateId = document.getElementById('updateIdInput').value;
    
    try {
        let response = await fetch(API_URL);
        let data = await response.json();
        
        let emp = data.find(emp => emp._id === updateId);
        console.log(emp);
        
        if (emp) {
            document.getElementById('updateName').value = emp.name;
            document.getElementById('updatePosition').value = emp.position;
            document.getElementById('updateForm').setAttribute('data-id', emp._id);
            document.getElementById('updateForm').style.display = 'block';
        } else {
            alert("Employee not found");
        }
    } catch (error) {
        console.error("Error fetching employee for update:", error);
    }
}

async function updateEmployee(event) {
    event.preventDefault();
    let updateId = document.getElementById('updateForm').getAttribute('data-id');
    let name = document.getElementById('updateName').value;
    let position = document.getElementById('updatePosition').value;
    
    try {
        await fetch(`${API_URL}/${updateId}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ name, position })
        });
        event.target.reset();
        // showEmployees();
    } catch (error) {
        console.error("Error updating employee:", error);
    }
}

async function confirmRemoveEmployee() {
    let removeId = document.getElementById('removeIdInput').value;
    
    try {
        let response = await fetch(API_URL);
        let data = await response.json();
        let emp = data.find(emp => emp._id === removeId);
        if (emp) {
            document.getElementById('removeEmployeeInfo').innerText = `Remove ${emp.name} - ${emp.position}?`;
            document.getElementById('removeConfirmation').setAttribute('data-id', emp._id);
            document.getElementById('removeConfirmation').style.display = 'block';
        } else {
            alert("Employee not found");
        }
    } catch (error) {
        console.error("Error fetching employee for removal:", error);
    }
}

async function removeEmployee() {
    let removeId = document.getElementById('removeConfirmation').getAttribute('data-id');
    
    try {
        await fetch(`${API_URL}/${removeId}`, {
            method: 'DELETE'
        });
        document.getElementById('removeConfirmation').style.display = 'none';
        // showEmployees();
    } catch (error) {
        console.error("Error removing employee:", error);
    }
}

function cancelRemove() {
    document.getElementById('removeConfirmation').style.display = 'none';
}
