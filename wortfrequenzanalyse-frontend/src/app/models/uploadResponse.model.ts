export enum UploadResponseStatus {OK="OK", ERROR="ERROR"}

export interface UploadResponse {
    status: UploadResponseStatus,
    message: string
}