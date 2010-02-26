//    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
          String arr1 = this.txtf1.getText();
          String arr1NoSpacesBE = arr1.trim();
          String arr1NoSpaces = arr1NoSpacesBE.replace(" ", "");
          
          ArrayList lst = new ArrayList();
          int tmhString = arr1NoSpaces.length();

          for(int i = 0; tmhString > i; i++){
              if(!(i+2 > tmhString)){
                    try{
                        int resto = 0;
                        resto = i%2;
                        if(resto == 0)
                            lst.add(arr1NoSpaces.substring(i, i+2));
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Erro! => " + e.getLocalizedMessage() + " :: " + e.getMessage());
                    }
              }
          }
         Integer qtdDezenas = (Integer) lst.size();
         jLabel3.setText(qtdDezenas.toString());

         Random rdm = new Random();

         Collections.shuffle(lst, rdm);
         
         Object[] lista = new Object[6];

         int controlador2 = 6;
         for(int i = 0; controlador2 > i; i++){
              lista[i] = lst.get(i);
         }

         int flagMsg = 0;
         // Verifica se tem algum numero repetido.. begin: percorre todos as dezenas
         for(int i = 0; i < 6; i++){
             int x = Integer.parseInt(lista[i].toString());
             int contador = 0; // registra qtd de ocorrencias de dezena repetida
             
             /**
              * Na dezena X armazena esse valor em uma vari�vel, e percorre o restante
              * das dezenas em procura do mesmo n�mero, caso tenha 2 ocorr�ncias cria um alerta
              *
              */
             for(int i2 = 0; i2 < 6; i2++){
                 int x2 = Integer.parseInt(lista[i2].toString());
                 if(x == x2){
                     contador = contador + 1;
                     //JOptionPane.showMessageDialog(null, "1 ocorrencia!");
                     if(contador == 2){
                        flagMsg = flagMsg + 1;
                        if(flagMsg == 2)
                            JOptionPane.showMessageDialog(null, "Numero repetido!: " + x);
                     }
                 }
             }
         }

         ((DefaultTableModel)jTable1.getModel()).addRow(lista);


    }//GEN-LAST:event_jButton1MouseClicked