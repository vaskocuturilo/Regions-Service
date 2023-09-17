import React, { useEffect } from "react";
import  'bootstrap/dist/css/bootstrap.min.css';
import styles from 'bootstrap/dist/css/bootstrap.css';
import Modal from "./Modal";


function Popup() {
    const [visible, setVisible] = React.useState(false);
    useEffect(()=>{
      let pop_status = localStorage.getItem('pop_status');
      if(!pop_status){
        setVisible(true);
        localStorage.setItem('pop_status',1);
      }
    },[])
    if(!visible) return null;

    return (
        <div className={styles.popup} onClick={() => setVisible(false)}>
            <div className={styles.popupInner}>
                <div className={styles.buttonContainer}>
                    <Modal></Modal>
                </div>
            </div>    
        </div>
    )
}

export default Popup;