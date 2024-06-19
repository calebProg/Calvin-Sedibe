import tkinter as tk
from py4j.java_gateway import JavaGateway

# Connect to the Java Gateway
gateway = JavaGateway()
hello_world = gateway.entry_point.getHelloWorld()

# Create the main window
root = tk.Tk()
root.title("Python GUI for Java Application")

# Define a function to update the label with the Java message
def update_message():
    message = hello_world.getMessage()
    label.config(text=message)

# Create a label to display the message
label = tk.Label(root, text="Click the button to get a message from Java")
label.pack(pady=10)

# Create a button to trigger the update_message function
button = tk.Button(root, text="Get Message", command=update_message)
button.pack(pady=10)

# Run the application
root.mainloop()
