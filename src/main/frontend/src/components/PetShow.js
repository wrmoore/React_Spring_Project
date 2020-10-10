import React, { useState, useEffect } from 'react'
import PetAdoptionsForm from './PetAdoptionsForm'

const PetShow = (props) => {
  let petId = props.match.params.id
  const [displayForm, setDisplayForm] = useState(false)
  const [pet, setPet] = useState([])
  const [pageFound, setPageFound] = useState(true)
  const [applicationStatus, setApplicationStatus] = useState("")

  let vaccinated = pet.vaccination_status === true? "Yes" : "No"

    useEffect(() => {
      fetch(`/api/v1${props.location.pathname}`)
       .then(response => {
         if (response.ok) {
         return response
       } else {
         setPageFound(false)
       }
     })
       .then(result =>  result.json())
       .then(pet => {
         setPet(pet)
       })
     }, []);

  const handleAdoptClick = () => {
    let formState = displayForm === true ? false : true
    setDisplayForm(formState)
  }

  let adoptForm;
  if (applicationStatus === "pending") adoptForm = "Your request is in process"
  else {
    adoptForm = displayForm === true ? 
    <PetAdoptionsForm pet_id={pet.id} 
      setApplicationStatus={setApplicationStatus}
      setDisplayForm={setDisplayForm}
      /> : <button onClick={handleAdoptClick}>Adopt Me!</button>
  }
  let response
  if(!pageFound) {
  response = (
  <h1>404 Page Not Found</h1>
  )
  } else {
  response = (
     <div>
       <h1>Adopt Me!!</h1>

       <h3>Name: {pet.name}</h3>
       <img className="pet-image" src={pet.imageUrl} />
       <p>Age: {pet.age}</p>
       <p>Vaccinated: {vaccinated}</p>
       <p>{pet.adoptionStory}</p>

       {adoptForm}
     </div>
   );
  }


  return response
}

export default PetShow
