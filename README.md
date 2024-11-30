# Cloud Drive with SpringBoot and MySQL

## Project Overview

This is the backend of a cloud storage system built using **SpringBoot** and **MySQL**, designed to support file storage, management, sharing, and online video preview features. It allows users to upload and manage files efficiently, as well as stream videos directly from the platform.

## Tech Stack

- **SpringBoot**: For building the web application and backend services.
- **MySQL**: For managing user and file data.
- **Redis**: For caching to improve performance.
- **FFmpeg**: For video processing and enabling online video previews.

## Key Features & Work

1. **User Registration & Login**
   - Implemented user authentication and verification features, ensuring secure registration and login processes.
2. **Large File Chunk Upload & Merge**
   - Developed an asynchronous backend process for uploading large files in chunks, supporting **resumable uploads** to improve performance and reliability.
3. **Fast Upload Feature**
   - Enabled a fast upload feature by using **MD5 checksums**, allowing the system to detect and prevent duplicate uploads, optimizing storage and bandwidth usage.
4. **Video Streaming**
   - Integrated **FFmpeg** to slice videos for online preview functionality, providing users with smooth video playback experiences directly on the platform.
5. **File Management**
   - Implemented key file management features, including file deletion, download, and sharing capabilities.
6. **Redis Cache Optimization**
   - Used Redis to cache file chunk sizes, reducing database read/write pressure and significantly enhancing system performance.
