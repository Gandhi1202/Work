import React from 'react';
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonInput, IonLabel, IonItem, IonList } from '@ionic/react';

const Change: React.FC = () => {
  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Change Password</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent className="ion-padding">
        <IonList>
          <IonItem>
            <IonLabel position="stacked">Old Password</IonLabel>
            <IonInput type="password" id="oldpass" name="oldpass" />
          </IonItem>

          <IonItem>
            <IonLabel position="stacked">New Password</IonLabel>
            <IonInput type="password" id="newpass" name="newpass" />
          </IonItem>

          <IonItem>
            <IonLabel position="stacked">Confirm Password</IonLabel>
            <IonInput type="password" id="conf" name="conf" />
          </IonItem>
        </IonList>
      </IonContent>
    </IonPage>
  );
};

export default Change;
