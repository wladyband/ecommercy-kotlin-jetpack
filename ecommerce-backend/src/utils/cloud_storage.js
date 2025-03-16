import { Storage } from '@google-cloud/storage';

import { format } from 'util';
//import * as env from './config/env'; // Ajuste o caminho conforme necessário
//import * as url from 'url';
import { v4 as uuidv4 } from 'uuid';
const uuid = uuidv4();

const storage = new Storage({
  projectId: 'ecommercyapp-8d1c9',
  keyFilename: './serviceAccountKey.json',
});

const bucket = storage.bucket('gs://ecommercyapp-8d1c9.firebasestorage.app/');

/**
 * Subir el archivo a Firebase Storage
 * file objeto que sera almacenado en Firebase Storage
 */
module.exports = (file, pathImage) => {
  return new Promise((resolve, reject) => {
    if (pathImage) {
      if (pathImage != null || pathImage != undefined) {
        let fileUpload = bucket.file(`${pathImage}`);
        const blobStream = fileUpload.createWriteStream({
          metadata: {
            contentType: 'image/png',
            metadata: {
              firebaseStorageDownloadTokens: uuid,
            },
          },
          resumable: false,
        });

        blobStream.on('error', (error) => {
          console.log('Error al subir archivo a firebase', error);
          reject('Something is wrong! Unable to upload at the moment.');
        });

        blobStream.on('finish', () => {
          // The public URL can be used to directly access the file via HTTP.
          const url = format(
            `https://firebasestorage.googleapis.com/v0/b/${bucket.name}/o/${fileUpload.name}?alt=media&token=${uuid}`,
          );
          console.log('URL DE CLOUD STORAGE ', url);
          resolve(url);
        });

        blobStream.end(file.buffer);
      }
    }
  });
};
