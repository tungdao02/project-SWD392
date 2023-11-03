document.addEventListener('DOMContentLoaded', function () {
    const rows = document.querySelectorAll('tbody tr');
    rows.forEach(row => {
        row.addEventListener('dblclick', function() {
            const modal = new bootstrap.Modal(document.getElementById('subjectEditModal'));
            const id = row.querySelector('th').innerText;
            const name = row.querySelector('td:nth-child(2)').innerText;
            const description = row.querySelector('td:nth-child(3)').innerText;
            const status = row.querySelector('td:nth-child(4)').innerText;
            const manager = row.querySelector('td:nth-child(5)').innerText;

            document.getElementById('editId').value = id;
            document.getElementById('editName').value = name;
            document.getElementById('editDescription').value = description;
            document.getElementById('editStatus').value = status;
            document.getElementById('editManager').value = manager;

            const deleteButton = document.getElementById('deleteButton');
            deleteButton.setAttribute('data-id', id);
            modal.show();
        });
    });
});

function deleteSubject() {
    const subjectId = document.getElementById('deleteButton').getAttribute('data-id');
    fetch(`/subject/delete?id=${subjectId}`, {
        method: 'GET'
    }).then(response => {
        if (response.redirected) {
            window.location.href = response.url;
        }
    }).catch(error => {
        console.error('Error:', error);
    });
}

