document.getElementById('clienteForm').addEventListener('submit', function (e) {
    e.preventDefault();
  
    const cliente = {
      nome: document.getElementById('nome').value,
      idade: parseInt(document.getElementById('idade').value),
      sexo: document.getElementById('sexo').value
    };
  
    fetch('http://localhost:8080/api/clientes', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(cliente)
    })
    .then(response => {
      if (!response.ok) {
        throw new Error("Erro ao cadastrar");
      }
      return response.json();
    })
    .then(data => alert('Cliente cadastrado com sucesso! ID: ' + data.id))
    .catch(error => alert('Erro ao cadastrar cliente: ' + error.message));
  });
  