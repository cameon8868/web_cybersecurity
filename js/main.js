document.getElementById("MyForm").addEventListener("submit", async function(e){
    e.preventDefault();

    const formData = new FormData(this);

    try{
        const response = await fetch("/submit", {
            method: "POST",
            body: formData
        });
        
        if(response.ok){
            document.getElementById("message").classList.add("message--visible");
        } else {
            alert("EROR IN SERVER");
        }
    }   catch(err) {
        console.error(err);
        alert("CANT CONNECT SERVER");
    }
});