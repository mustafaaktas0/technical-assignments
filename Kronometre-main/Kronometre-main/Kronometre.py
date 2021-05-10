#!/usr/bin/env python
# coding: utf-8

# In[1]:


import tkinter as Tkinter 
from datetime import datetime
counter =30
running =False

def CounterLabel(label):  
    def count():  
        if running:  
            global counter  
    
            if counter==30  :          
                display="count=30"
            else: 
                tt = datetime.fromtimestamp(counter) 
                string = tt.strftime("%S") 
                display=string  
    
            label['text']=display   
            label.after(1000, count)   
            counter -=1
    
    count()       
    
    
    
def Start(label):
    global running
    running=True
    CounterLabel(label)
    start["state"]="disabled"
    stop["state"]="normal"
    reset["state"]="normal"

def Stop():  
    global running  
    start['state']='normal'
    stop['state']='disabled'
    reset['state']='normal'
    running = False  


def Reset(label):  
    global counter  
    counter=30
    
    if running==False:        
        reset['state']='disabled'
        label['text']='merhaba'
    
   
    else:                 
        label['text']='count=30'
    
    
root=Tkinter.Tk()
root.geometry("400x400")
root.title("Kronometre")
label =Tkinter.Label(root,text ="merhaba ",font="Verdana 30 bold")
label.pack()
start =Tkinter.Button(root,text="Basla",fg="red",bg="yellow",width=20,font="Verdana 15 bold",command= lambda:Start(label))
stop =Tkinter.Button(root,text="Durdur",fg="red",bg="yellow",width=20,font="Verdana 15 bold",command=Stop)
reset =Tkinter.Button(root,text="Sıfırla",fg="red",bg="yellow",width=20,font="Verdana 15 bold",command=lambda:Reset(label))
start.pack(expand="YES")
stop.pack(expand="YES")
reset.pack(expand="YES")
root.mainloop()


# In[ ]:





# In[ ]:




