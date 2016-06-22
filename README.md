# MaterialDialog
This is a single file Class library for android. It has no dependencies. Just copy paste the file and use it.

for showing a dialog like material dialog you can use following code sni
```sh
 MaterialDialog materialDialog = new MaterialDialog();
        materialDialog.setMessage("you are so sweet!");
        materialDialog.setPositiveButton("yes", new MaterialDialog.OnPositiveButtonClick() {
            @Override
            public void onPositiveClick(View v) {
            //todo: change here to show event on click positive button.
                Toast.makeText(this, "yes", Toast.LENGTH_LONG).show();
            }
        });
        materialDialog.setNagativeButton("No", new MaterialDialog.OnNagativeButtonClick() {
            @Override
            public void onNagativeClick(View v) {
              //todo: change here to show event on click nagative button.
                Toast.makeText(PickActivity.this, "No", Toast.LENGTH_LONG).show();
            }
        });
        materialDialog.show(getFragmentManager(), "");</code>
```        
        then you will see Material dialog.
